package com.l7.dbdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.l7.dbdemo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
