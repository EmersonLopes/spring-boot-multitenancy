package com.example.springbootmultitenancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootmultitenancy.domain.UserDomain;

public interface UserRepository extends JpaRepository<UserDomain, Long> {

}
