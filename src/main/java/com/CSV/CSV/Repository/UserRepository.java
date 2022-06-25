package com.CSV.CSV.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CSV.CSV.Model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
