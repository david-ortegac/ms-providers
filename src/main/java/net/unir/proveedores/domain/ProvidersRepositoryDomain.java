package net.unir.proveedores.domain;

import net.unir.proveedores.domain.entities.ProviderDomainDTO;

import java.util.List;

public interface ProvidersRepositoryDomain {
    Long getProvidersCount();
    List<ProviderDomainDTO> getAll();
    ProviderDomainDTO getById(Long id);
    ProviderDomainDTO save();
    ProviderDomainDTO update();
    ProviderDomainDTO delete();
}
