package br.com.maelton.bsc.infrastructure.organization.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maelton.bsc.application.organization.port.in.CreateOrganizationResult;
import br.com.maelton.bsc.application.organization.port.in.CreateOrganizationUseCase;
import br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto.CreateOrganizationRequestDto;
import br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto.OrganizationResponseDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/orgs")
public class OrganizationController {
    private final CreateOrganizationUseCase createOrgUseCase;
    private final OrganizationWebMapper webMapper;
    
    public OrganizationController(
        CreateOrganizationUseCase createOrgUseCase,
        OrganizationWebMapper webMapper
    ) {
        this.createOrgUseCase = createOrgUseCase;
        this.webMapper = webMapper;
    }

    @PostMapping
    public ResponseEntity<OrganizationResponseDto> create(
        @RequestBody @Valid CreateOrganizationRequestDto dto
    ) {
        CreateOrganizationResult org = createOrgUseCase.create(
            webMapper.toCreateOrganizationCommand(dto)
        );

        OrganizationResponseDto response = webMapper.toOrganizationResponseDto(org);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }   
}
