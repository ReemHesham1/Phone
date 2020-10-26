package com.phoneBook.ContactManegement.reposotories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phoneBook.ContactManegement.entities.phoneNumbersEntity;

@Repository
public interface PhoneNumberRepository extends JpaRepository<phoneNumbersEntity, Long> {

}
