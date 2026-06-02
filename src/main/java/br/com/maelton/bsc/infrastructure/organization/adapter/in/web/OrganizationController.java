package br.com.maelton.bsc.infrastructure.organization.adapter.in.web;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maelton.bsc.application.organization.port.in.ManageOrganizationUseCase;
import br.com.maelton.bsc.application.organization.response.OrganizationResponse;
import br.com.maelton.bsc.domain.organization.entity.OrganizationId;
import br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto.CreateUpdateOrganizationDto;
import br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto.OrganizationResponseDto;
import br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto.PatchOrganizationDto;
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
        @RequestBody @Valid CreateUpdateOrganizationDto dto
    ) {
        OrganizationResponse org = manageOrgUseCase.create(
            webMapper.toCreateUpdateOrganizationCommand(dto)
        );

        OrganizationResponseDto response = webMapper.toOrganizationResponseDto(org);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OrganizationResponseDto> getByUuid(@PathVariable UUID uuid) {
        OrganizationId id = new OrganizationId(uuid);
        OrganizationResponse org = manageOrgUseCase.getById(id);
        
        OrganizationResponseDto response = webMapper.toOrganizationResponseDto(org);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<OrganizationResponseDto>> getAll() {
        List<OrganizationResponse> orgs = manageOrgUseCase.listAll();
        List<OrganizationResponseDto> response = orgs.stream()
                                                    .map(webMapper::toOrganizationResponseDto)
                                                    .toList();
                                                    
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<OrganizationResponseDto> updateByUuid(
        @PathVariable UUID uuid, 
        @RequestBody @Valid CreateUpdateOrganizationDto dto
    ) {
        OrganizationId id = new OrganizationId(uuid);
        OrganizationResponse updated = manageOrgUseCase.update(
            id,
            webMapper.toCreateUpdateOrganizationCommand(dto) 
        );
        
        OrganizationResponseDto response = webMapper.toOrganizationResponseDto(updated);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{uuid}")
    public ResponseEntity<OrganizationResponseDto> patchByUuid(
        @PathVariable UUID uuid,
        @RequestBody PatchOrganizationDto dto
    ) {
        OrganizationId id = new OrganizationId(uuid);
        OrganizationResponse patched = manageOrgUseCase.patch(
            id,
            webMapper.toPatchOrganizationCommand(dto) 
        );
        
        OrganizationResponseDto response = webMapper.toOrganizationResponseDto(patched);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteByUuid(@PathVariable UUID uuid) {
        return ResponseEntity.noContent().build();
    }    
}
