package com.Assignment.Product.Dto;

import java.util.UUID;

public class ProductDto {

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
