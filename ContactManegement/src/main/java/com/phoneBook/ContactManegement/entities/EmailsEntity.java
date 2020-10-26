package com.phoneBook.ContactManegement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "emails")
public class EmailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	@NotNull
	private String email;

	@ManyToOne
	@JoinColumn(name = "contact_id", nullable = false)
	private ContactsEntity emailContact;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ContactsEntity getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(ContactsEntity emailContact) {
		this.emailContact = emailContact;
	}

}
