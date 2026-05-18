package br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto;

import java.util.List;
import java.util.UUID;

public record OrganizationResponseDto(
    UUID uuid,
    String name,
    String mission,
    String vision,
    List<String> values
) {}
