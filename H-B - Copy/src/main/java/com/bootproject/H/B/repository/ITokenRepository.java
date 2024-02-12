package com.bootproject.H.B.repository;

import com.bootproject.H.B.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepository extends JpaRepository<Token, Integer>{

    Token findByConfirmationToken(String token);
}
