package net.unir.proveedores.domain;

import net.unir.proveedores.domain.entities.ProviderDomainDTO;
import net.unir.proveedores.infraestructure.entities.PageAndFilterParamsDomain;

import java.util.List;

public interface ProvidersRepositoryDomain {
    Long getProvidersCount();
    List<ProviderDomainDTO> getAll(PageAndFilterParamsDomain filter);
    ProviderDomainDTO getById(Long id);
    ProviderDomainDTO save(ProviderDomainDTO domainDTO);
    ProviderDomainDTO delete(Long id);
}
