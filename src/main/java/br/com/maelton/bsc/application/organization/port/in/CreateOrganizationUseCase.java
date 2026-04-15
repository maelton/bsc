package br.com.maelton.bsc.application.organization.port.in;

public interface CreateOrganizationUseCase {
    CreateOrganizationResult create(CreateOrganizationCommand command);
}
