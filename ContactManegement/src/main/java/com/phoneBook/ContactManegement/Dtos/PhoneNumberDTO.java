package com.phoneBook.ContactManegement.Dtos;

import lombok.Data;

@Data
public class PhoneNumberDTO {

	private Long id;
	private String phoneNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
