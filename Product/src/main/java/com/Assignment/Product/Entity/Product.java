package com.Assignment.Product.Entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Product {

	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private UUID Id;
private String name;
private UUID UserId;
public UUID getId() {
	return Id;
}
public void setId(UUID id) {
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public UUID getUserId() {
	return UserId;
}
public void setUserId(UUID userId) {
	UserId = userId;
}

}
