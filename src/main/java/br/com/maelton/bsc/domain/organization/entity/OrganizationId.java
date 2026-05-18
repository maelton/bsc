package br.com.maelton.bsc.domain.organization.entity;

import java.util.Objects;
import java.util.UUID;

public record OrganizationId(UUID value) {
    public OrganizationId {
        Objects.requireNonNull(value, "OrganizationId value is required.");
    }

    public static OrganizationId generate() {
        return new OrganizationId(UUID.randomUUID());
    }
}
