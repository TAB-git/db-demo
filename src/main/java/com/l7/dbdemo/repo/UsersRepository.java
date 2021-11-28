package com.l7.dbdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.l7.dbdemo.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
