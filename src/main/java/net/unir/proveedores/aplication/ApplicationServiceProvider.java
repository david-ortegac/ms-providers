package net.unir.proveedores.aplication;

import net.unir.proveedores.adapter.restful.v1.models.ProviderAdapterDTO;
import net.unir.proveedores.domain.entities.ProviderDomainDTO;

import java.util.List;

public interface ApplicationServiceProvider {
    ProviderDomainDTO getProvidersById(Long id);
    List<ProviderAdapterDTO> getAll();
    Long getCountProviders();
    ProviderDomainDTO saveProvider(ProviderAdapterDTO adapterDTO);
    ProviderDomainDTO deleteProvider(Long id);
}
