package com.example.blog.model;

import com.example.blog.enumerated.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "roles")
@NoArgsConstructor
public class Role {
    @Id
    private String id = UUID.randomUUID().toString();

    @Enumerated(EnumType.STRING)
    private RoleType name;

    public Role(RoleType name) {
        this.name = name;
    }

    @Column(name = "user_id")
    protected String userId;
}
