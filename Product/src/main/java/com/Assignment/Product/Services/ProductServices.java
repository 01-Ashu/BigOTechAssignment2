package com.Assignment.Product.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Assignment.Product.Dto.ProductDto;
import com.Assignment.Product.Entity.Product;
import com.Assignment.Product.Repository.ProductRepository;
import com.Assignment.Product.User.Client.UserClient;
import com.Assignment.Product.User.Entities.UserDto;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private UserClient userClient;

    private ModelMapper modelMapper = new ModelMapper();
    
    public ProductDto createProduct(ProductDto prod) {
        Product prd = modelMapper.map(prod, Product.class);
        Product savedProd = this.productRepo.save(prd);
        return modelMapper.map(savedProd, ProductDto.class);
    }
        
    public List<ProductDto> getAllProduct() {
        List<Product> listProduct = this.productRepo.findAll();
        List<ProductDto> listProductDto = new ArrayList<>();
        for (Product it : listProduct) {
            listProductDto.add(modelMapper.map(it, ProductDto.class));
        }
        return listProductDto;
    }

    public ProductDto getSingleProduct(UUID id) {
        Product prd = this.productRepo.findById(id).orElse(null);
        return modelMapper.map(prd, ProductDto.class);
    }

   

 
}
