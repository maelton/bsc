package br.com.maelton.bsc.domain.entity;

import java.util.Objects;
import java.util.UUID;

public record OrganizationId(UUID value) {
    public OrganizationId {
        Objects.requireNonNull(value, "value cannot be null");
    }

    public static OrganizationId generate() {
        return new OrganizationId(UUID.randomUUID());
    }
}
