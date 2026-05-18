package br.com.maelton.bsc.domain.organization.vo;

import java.util.Objects;

public record OrganizationName(String value) {
    public OrganizationName {
        Objects.requireNonNull(value, "OrganizationName value is required.");
        if(value.trim().length() < 1) {
            throw new IllegalArgumentException(
                "OrganizationName value must contain at least 1 character"
            );
        }
    }
}
