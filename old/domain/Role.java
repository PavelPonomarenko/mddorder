package ua.com.mddorder.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;


@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "user")
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private RoleType roleType;

    @Column(name = "creation_date")
    private LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static Role valueOf(RoleType roleType) {
        return new Role(roleType);
    }

    private Role(RoleType roleType) {
        this.roleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}