package com.Assignment.Product.User.Client;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;

import com.Assignment.Product.User.Entities.UserDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserClient {
	
	 
	  @GET("api/v1/users/")
	 public   Call<List<UserDto>> getAllUsers();
	  
	  @GET("api/v1/users/{Id}")
	public   Call<UserDto>GetUserById(@Path("Id") UUID Id);
	  
}
