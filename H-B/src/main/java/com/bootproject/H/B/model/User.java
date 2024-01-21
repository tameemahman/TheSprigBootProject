package com.bootproject.H.B.model;


import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    private  String lastName;

    @Column(nullable = false, unique = true)
    @NotNull
//    @Email(message = "{errors.invalid_email}")
    private  String email;
    @NotNull
    private  String password;


//    private List<Role> roles;


}
