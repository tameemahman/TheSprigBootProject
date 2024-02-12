package com.bootproject.H.B.repository;

import com.bootproject.H.B.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    //    @Query("select  u from User u where u.email=:email")
    User findByEmail(@Param("email") String email);

}