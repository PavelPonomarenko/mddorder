package ua.com.mddorder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@MappedSuperclass
public class NamedEntity extends BaseEntity {

//    @Column(name = "name")
    private String name;

//    @Column(name = "surname")
    private String surname;
}
