package br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateUpdateOrganizationDto(
    @NotNull
    @NotBlank
    @Size(min=1)
    String name,
    String mission,
    String vision,
    Set<String> values
) {}
