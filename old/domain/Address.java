package ua.com.mddorder.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(exclude = "user")
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "apartment_number")
    private String apartmentNumber;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}