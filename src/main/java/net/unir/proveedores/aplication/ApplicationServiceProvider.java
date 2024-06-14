package net.unir.proveedores.aplication;

import net.unir.proveedores.adapter.restful.v1.models.ProviderAdapterDTO;
import net.unir.proveedores.domain.entities.ProviderDomainDTO;

import java.util.List;

public interface ApplicationServiceProvider {
    ProviderDomainDTO getProvidersById(Long id);
    List<ProviderAdapterDTO> getAll(String name, String LastName, String address, String email, String phone);
    ProviderDomainDTO saveProvider(ProviderAdapterDTO adapterDTO) throws Exception;
    ProviderDomainDTO updateProvider(Long id, ProviderAdapterDTO adapterDTO);
    ProviderDomainDTO deleteProvider(Long id);
}
