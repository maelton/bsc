package br.com.maelton.bsc.infrastructure.organization.adapter.in.web;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maelton.bsc.application.organization.port.in.ManageOrganizationUseCase;
import br.com.maelton.bsc.application.organization.response.OrganizationResponse;
import br.com.maelton.bsc.domain.organization.entity.OrganizationId;
import br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto.CreateOrganizationDto;
import br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto.OrganizationResponseDto;
import jakarta.validation.Valid;


@RestController
@RequestMapping("api/v1/orgs")
public class OrganizationController {
    private final ManageOrganizationUseCase manageOrgUseCase;
    private final OrganizationWebMapper webMapper;
    
    public OrganizationController(
        ManageOrganizationUseCase manageOrgUseCase,
        OrganizationWebMapper webMapper
    ) {
        this.manageOrgUseCase = manageOrgUseCase;
        this.webMapper = webMapper;
    }

    @PostMapping
    public ResponseEntity<OrganizationResponseDto> create(
        @RequestBody @Valid CreateOrganizationDto dto
    ) {
        OrganizationResponse org = manageOrgUseCase.create(
            webMapper.toCreateOrganizationCommand(dto)
        );

        OrganizationResponseDto response = webMapper.toOrganizationResponseDto(org);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OrganizationResponseDto> getByUuid(@PathVariable UUID uuid) {
        OrganizationId id = new OrganizationId(uuid);
        OrganizationResponse org = manageOrgUseCase.findById(id);
        
        OrganizationResponseDto response = webMapper.toOrganizationResponseDto(org);
        return ResponseEntity.ok(response);
    }
}
