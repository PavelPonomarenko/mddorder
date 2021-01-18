package ua.com.mddorder.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@Data
//@Entity
//@Table(name = "employees")
public class Employee extends NamedEntity {

    @Column(name = "username")
    protected String username;
    @Column(name = "password")
    protected String password;

    @Column(name = "enabled", nullable = false)
    protected boolean enabled = true;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    protected Date registered = new Date();

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    protected Set<Role> roles;




}
