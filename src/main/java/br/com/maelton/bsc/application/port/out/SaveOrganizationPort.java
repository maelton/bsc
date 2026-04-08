package br.com.maelton.bsc.application.port.out;

import br.com.maelton.bsc.domain.entity.Organization;

public interface SaveOrganizationPort {
    void save(Organization organization);
}
