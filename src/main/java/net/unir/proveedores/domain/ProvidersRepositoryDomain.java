package net.unir.proveedores.domain;

import net.unir.proveedores.domain.entities.ProviderDomainDTO;

import java.util.List;

public interface ProvidersRepositoryDomain {
    List<ProviderDomainDTO> getAll();
    List<ProviderDomainDTO> search(String name, String lastName, String address, String email, String phone);
    ProviderDomainDTO getById(Long id);
    ProviderDomainDTO save(ProviderDomainDTO domainDTO);
    ProviderDomainDTO delete(Long id);
}
