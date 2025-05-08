package nimap.assignment.controller;

import nimap.assignment.Exception.ResourceNotFoundException;
import nimap.assignment.dto.ProductDTO;
import nimap.assignment.entity.Product;
import nimap.assignment.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // ✅ Create Product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        Product saved = productService.createProduct(product);
        ProductDTO dto = productService.convertToDTO(saved);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    // ✅ Get Product by ID (with category info via DTO)
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));
        ProductDTO dto = productService.convertToDTO(product);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // ✅ Get all products with pagination
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productService.getAllProducts(pageable);

        Page<ProductDTO> dtoPage = productPage.map(productService::convertToDTO);

        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
    }

    // ✅ Update product (with existence check)
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        // Check if product exists
        Product existing = productService.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));

        Product updated = productService.updateProduct(id, product);
        ProductDTO dto = productService.convertToDTO(updated);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // ✅ Delete product (with existence check)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
