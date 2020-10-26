package com.phoneBook.ContactManegement.Dtos;

import java.util.List;

import lombok.Data;

@Data
public class ContactsDTO {

	private Long id;
	private String name;
	private String address;
	private String emergencyNumber;
	List<PhoneNumberDTO> phoneNumbers;
	List<EmailsDTO> emails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmergencyNumber() {
		return emergencyNumber;
	}

	public void setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = emergencyNumber;
	}

	public List<PhoneNumberDTO> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumberDTO> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<EmailsDTO> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailsDTO> emails) {
		this.emails = emails;
	}

}
