package com.example.blog.enumerated;

import lombok.Getter;

@Getter
public enum RoleType {

    ADMIN("administrator"),
    USER("user");

    private final String displayName;

    RoleType(String displayName) {
        this.displayName = displayName;
    }
}
