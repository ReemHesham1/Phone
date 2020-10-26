package com.phoneBook.ContactManegement.reposotories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phoneBook.ContactManegement.entities.ContactsEntity;

@Repository
public interface ContactsRepository extends JpaRepository<ContactsEntity, Long> {

	List<ContactsEntity> findByName(String name);
}
