package br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto;

import java.util.Set;
import java.util.UUID;

public record OrganizationResponseDto(
    UUID uuid,
    String name,
    String mission,
    String vision,
    Set<String> values
) {}
