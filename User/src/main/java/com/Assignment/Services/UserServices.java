package com.Assignment.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Assignment.Dto.UserDto;
import com.Assignment.Entity.User;
import com.Assignment.Entity.Repository.UserRepository;

@Service
public class UserServices {
	  @Autowired
		private UserRepository UserRepo;
	         @Autowired
	    private ModelMapper modelMapper;
	    
	        public UserDto CreateUser(UserDto user) {
//	        	User usr=modelMapper.map(user,User.class);
	        	User usr=this.DtoToUser(user);
	        	
	        	User savedUser=this.UserRepo.save(usr);
	        	
//	        	UserDto UsrDto=modelMapper.map(savedUser,UserDto.class);
	        	UserDto UsrDto=this.UserToDto(savedUser);
	        	return UsrDto;
	    	
	        }
	        
	       public List<UserDto> GetAllUser(){
	    	   List<User> listUser=this.UserRepo.findAll();
	    	   List<UserDto>listUserDto=new ArrayList<>();
	    	   
	    	   for(User it:listUser) {
	    		   listUserDto.add(modelMapper.map(it,UserDto.class ));
	    		   
	    	   }
	    	   return listUserDto;
	    	   
	       }
	       public UserDto GetUserById(UUID Id) {
	    	   User usr=this.UserRepo.findById(Id).orElse(null);
	    	   return modelMapper.map(usr, UserDto.class);
	    	   
	       }
	       public User DtoToUser(UserDto usrDto) {
	    	   User u=new User();
	    	   u.setID(usrDto.getID());
	    	   u.setName(usrDto.getName());
	    	   return u;
	       }
	       public UserDto UserToDto(User usr) {
	    	   UserDto u=new UserDto();
	    	   u.setID(usr.getID());
	    	   u.setName(usr.getName());
	    	   return u;
	       }
	
}
