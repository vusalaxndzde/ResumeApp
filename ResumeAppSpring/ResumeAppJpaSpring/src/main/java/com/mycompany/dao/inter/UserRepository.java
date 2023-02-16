package com.mycompany.dao.inter;

import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findBySurname(String surname);

    User findByEmailAndName(String email, String name);

    List<User> findByEmailOrName(String email, String name);

    @Query("select u from User u where u.name = :name and u.surname = :surname")
    User findByName(@Param("name") String alma, @Param("surname") String armud);

//    @Query("select u from User u where u.name = ?1 and u.surname = ?2")
//    User findByName(String alma, String armud);
}
