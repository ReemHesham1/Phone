package com.phoneBook.ContactManegement.reposotories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phoneBook.ContactManegement.entities.EmailsEntity;

@Repository
public interface EmailRepository extends JpaRepository<EmailsEntity, Long> {

}
