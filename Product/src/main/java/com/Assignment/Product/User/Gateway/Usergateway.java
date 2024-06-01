package com.Assignment.Product.User.Gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.Assignment.Product.Services.ProductServices;
import com.Assignment.Product.User.Client.UserClient;
import com.Assignment.Product.User.Entities.UserDto;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class Usergateway {


	 @Autowired
	    private UserClient userClient;

	    public List<UserDto> getAllUsers() {
	        try {
	            Call<List<UserDto>> call = userClient.getAllUsers();
	            Response<List<UserDto>> response = call.execute();
	            if (response.isSuccessful()) {
	                return response.body();
	            } else {
	                return new ArrayList<>();
	            }
	        } catch (Exception e) {
	            return new ArrayList<>();
	        }
	    }
	  
	    public UserDto getUserById(UUID id) {
	        try {
	            Call<UserDto> call = userClient.GetUserById(id);
	            Response<UserDto> response = call.execute();
	            if (response.isSuccessful()) {
	                return response.body();
	            } else {
	                return null;
	            }
	        } catch (Exception e) {
	            return null;
	        }
	    }
}
