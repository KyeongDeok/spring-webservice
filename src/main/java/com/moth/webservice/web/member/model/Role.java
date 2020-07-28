package com.moth.webservice.web.member.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum Role {

    GUEST("ROLE_GUEST","손님"),
    USER("ROLE_USER","일반 사용자"),
    ADMIN("ROLE_ADMIN","관리자");

    private final String role;
    private final String description;

    Role(String role, String description) {
        this.role = role;
        this.description = description;
    }
}
