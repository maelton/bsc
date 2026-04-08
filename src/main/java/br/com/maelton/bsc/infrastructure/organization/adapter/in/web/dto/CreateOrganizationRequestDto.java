package br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateOrganizationRequestDto(
    @NotBlank
    @Size(min=3)
    String name
) {}
