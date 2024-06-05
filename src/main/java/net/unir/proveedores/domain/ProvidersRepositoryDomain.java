package net.unir.proveedores.domain;

import net.unir.proveedores.adapter.restful.v1.models.ProviderAdapterDTO;
import net.unir.proveedores.domain.entities.ProviderDomainDTO;

import java.util.List;

public interface ProvidersRepositoryDomain {
    Long getProvidersCount();
    List<ProviderDomainDTO> getAll();
    ProviderDomainDTO getById(Long id);
    ProviderDomainDTO save(ProviderAdapterDTO adapterDTO);
    ProviderDomainDTO update();
    ProviderDomainDTO delete(Long id);
}
