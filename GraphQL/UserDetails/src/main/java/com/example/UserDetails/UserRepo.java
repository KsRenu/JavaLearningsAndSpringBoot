package com.example.UserDetails;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,String> {
   // Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
    List<User> findUserByStatus(String status, Pageable pageable);

}
