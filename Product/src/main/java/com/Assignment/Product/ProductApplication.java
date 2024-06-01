package com.Assignment.Product;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.Assignment.Product.User.Client.UserClient;
import com.Assignment.Product.User.Config.userConfig;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductApplication {
	

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	
	 @Bean
	    public UserClient userClient() {
	        return userConfig.createService(UserClient.class);
	    }

}
