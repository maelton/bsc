package br.com.maelton.bsc.application.organization.service;

import java.util.List;
import java.util.Optional;

import br.com.maelton.bsc.application.organization.command.CreateOrganizationCommand;
import br.com.maelton.bsc.application.organization.port.in.ManageOrganizationUseCase;
import br.com.maelton.bsc.application.organization.port.out.OrganizationRepository;
import br.com.maelton.bsc.application.organization.response.OrganizationResponse;
import br.com.maelton.bsc.architecture.annotation.ApplicationService;
import br.com.maelton.bsc.domain.organization.entity.Organization;
import br.com.maelton.bsc.domain.organization.entity.OrganizationId;
import br.com.maelton.bsc.domain.organization.exception.OrganizationNotFoundException;

@ApplicationService
public class OrganizationService implements ManageOrganizationUseCase {
    private final OrganizationRepository orgRepository;

    public OrganizationService(OrganizationRepository orgRepository) {
        this.orgRepository = orgRepository;
    }

    @Override
    public OrganizationResponse create(CreateOrganizationCommand command) {
        Organization org = new Organization(
            command.name(),
            command.mission(),
            command.vision(),
            command.values()
        );
        Organization saved =  orgRepository.save(org);

        return OrganizationResponse.from(saved);
    }

    @Override
    public OrganizationResponse findById(OrganizationId id) {
        Optional<Organization> optional = orgRepository.findById(id);
        
        return optional.map(OrganizationResponse::from).orElseThrow(
                () -> new OrganizationNotFoundException(
                    String.format("Organization with ID '%s' could not be found", id.value())
                )
            );
    }

    @Override
    public List<OrganizationResponse> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public OrganizationResponse updateById(OrganizationId id, CreateOrganizationCommand command) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateById'");
    }

    @Override
    public void deleteById(OrganizationId id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}
