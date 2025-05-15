package com.ecom.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;
    @Autowired
    ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO dto) {
        productService.createProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDTO>> getAllProducts() throws ItemNotFoundException {
        List<ProductDTO> response = productService.getAllProducts();
        if (response.isEmpty()) {
            throw new ItemNotFoundException("not found");
        }
        return ResponseEntity.ok(response);
    }
}
