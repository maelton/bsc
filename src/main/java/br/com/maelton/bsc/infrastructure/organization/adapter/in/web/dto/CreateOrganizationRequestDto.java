package br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateOrganizationRequestDto(
    @NotNull
    @NotBlank
    @Size(min=3)
    String name,
    String mission,
    String vision,
    Set<String> values
) {}
