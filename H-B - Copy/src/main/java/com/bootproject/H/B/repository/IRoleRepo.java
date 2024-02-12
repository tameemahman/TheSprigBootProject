package com.bootproject.H.B.repository;

import com.bootproject.H.B.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepo extends JpaRepository<Role, Integer> {


}
