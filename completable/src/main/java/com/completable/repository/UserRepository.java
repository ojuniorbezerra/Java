package com.completable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.completable.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
