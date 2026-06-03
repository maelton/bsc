package br.com.maelton.bsc.application.organization.service;

import java.util.List;
import java.util.Optional;

import br.com.maelton.bsc.application.organization.command.CreateUpdateOrganizationCommand;
import br.com.maelton.bsc.application.organization.command.PatchOrganizationCommand;
import br.com.maelton.bsc.application.organization.port.in.ManageOrganizationUseCase;
import br.com.maelton.bsc.application.organization.port.out.OrganizationRepository;
import br.com.maelton.bsc.application.organization.response.OrganizationResponse;
import br.com.maelton.bsc.architecture.annotation.ApplicationService;
import br.com.maelton.bsc.domain.organization.entity.Organization;
import br.com.maelton.bsc.domain.organization.entity.OrganizationId;
import br.com.maelton.bsc.domain.organization.exception.OrganizationNotFoundException;
import br.com.maelton.bsc.domain.organization.vo.OrganizationName;

import jakarta.transaction.Transactional;

@Transactional
@ApplicationService
public class OrganizationService implements ManageOrganizationUseCase {
    private final OrganizationRepository orgRepository;

    public OrganizationService(OrganizationRepository orgRepository) {
        this.orgRepository = orgRepository;
    }

    @Override
    public OrganizationResponse create(CreateUpdateOrganizationCommand command) {
        Organization org = new Organization(
            command.name(),
            command.mission(),
            command.vision(),
            command.values()
        );
        Organization saved = orgRepository.create(org);

        return OrganizationResponse.from(saved);
    }

    @Override
    public OrganizationResponse getById(OrganizationId id) {
        Optional<Organization> optional = orgRepository.findById(id);
        
        return optional.map(OrganizationResponse::from).orElseThrow(
                () -> new OrganizationNotFoundException(
                    String.format("Organization with ID '%s' could not be found", id.value())
                )
            );
    }

    @Override
    public List<OrganizationResponse> listAll() {
        List<Organization> orgs = orgRepository.findAll();
        return orgs.stream().map(OrganizationResponse::from).toList();
    }

    @Override
    public OrganizationResponse update(OrganizationId id, CreateUpdateOrganizationCommand command) {
        Organization saved = orgRepository.findById(id).orElseThrow(
            () -> new OrganizationNotFoundException(
                String.format("Organization with ID '%s' could not be found", id.value())
            )
        );
        saved.update(
            new OrganizationName(command.name()), 
            command.mission(), 
            command.vision(), 
            command.values()
        );

        Organization updated = orgRepository.update(saved);
        return OrganizationResponse.from(updated);
    }

    @Override
    public OrganizationResponse patch(OrganizationId id, PatchOrganizationCommand command) {
        Organization saved = orgRepository.findById(id).orElseThrow(
            () -> new OrganizationNotFoundException(
                String.format("Organization with ID '%s' could not be found", id.value())
            )
        );
        saved.patch(
            command.name(), 
            command.mission(), 
            command.vision(), 
            command.values()
        );

        Organization patched = orgRepository.update(saved);
        return OrganizationResponse.from(patched);
    }

    @Override
    public void delete(OrganizationId id) {
        orgRepository.deleteById(id);
    }

}
