package br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto;

import java.util.UUID;

public record OrganizationResponseDto(
    Long id,
    UUID uuid,
    String name 
) {}
