package com.sportoras.database.repository;

import com.sportoras.database.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);

    List<User> findAllByUserDateilCompany(String compony);

}