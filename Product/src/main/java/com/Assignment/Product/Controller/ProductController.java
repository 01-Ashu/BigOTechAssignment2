package com.Assignment.Product.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Assignment.Product.Dto.ProductDto;
import com.Assignment.Product.Exception.ProductNotFoundException;
import com.Assignment.Product.Exception.UserNotFoundException;
import com.Assignment.Product.Services.ProductServices;
import com.Assignment.Product.User.Entities.UserDto;
import com.Assignment.Product.User.Gateway.Usergateway;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductServices prodService;
    
    @Autowired
    private Usergateway userGateway;
    

    @PostMapping("/")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto prd) {
        UUID id = prd.getUserId();
        UserDto call = userGateway.getUserById(id);
       
        if (call == null) {
            throw new UserNotFoundException("USER_NOT_FOUND", "User not found with ID: " + id);
        }

        ProductDto createdPrd = this.prodService.createProduct(prd);
        return new ResponseEntity<>(createdPrd, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        List<ProductDto> listprd = this.prodService.getAllProduct();
        return new ResponseEntity<>(listprd, HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable UUID Id) {
        ProductDto prd = this.prodService.getSingleProduct(Id);

        if (prd == null) {
            throw new ProductNotFoundException("PRODUCT_NOT_FOUND", "Product not found with ID: " + Id);
        }

        return new ResponseEntity<>(prd, HttpStatus.OK);
    }
}
