package com.example.blog.model;

import com.example.blog.enumerated.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "login"))
@NoArgsConstructor
public class User {
    @Id
    @Column(name="user_id")
    private String id = UUID.randomUUID().toString();

    private boolean lock = false;

    @NotNull
    private String login;

    @NotNull
    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User(@NotNull String login, @NotNull String passwordHash) {
        this.login = login;
        this.passwordHash = passwordHash;
    }

    public User(@NotNull String login, @NotNull String passwordHash, @NotNull Set<Role> roles) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.roles = roles;
    }
}
