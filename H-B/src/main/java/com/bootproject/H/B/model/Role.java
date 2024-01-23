package com.bootproject.H.B.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    public Role(int id) {
        this.id = id;
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Role role = (Role) o;
//        return id == role.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//
//    @Override
//    public String toString() {
//        return  this.name ;
//    }

}
