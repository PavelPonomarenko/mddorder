package ua.com.mddorder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
////@EqualsAndHashCode(of = "id")
//@EqualsAndHashCode(of = "id")
//@Access(AccessType.FIELD)
//@MappedSuperclass
public class BaseEntity {


//    @Id
//    @SequenceGenerator(
//            name = "baseEntity_sequence",
//            sequenceName = "baseEntity_sequence",
//            allocationSize = 1)
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "baseEntity_sequence")
    protected Long id;


}
