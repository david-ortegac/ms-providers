package net.unir.proveedores.adapter.restful.v1.mappers;

import net.unir.proveedores.adapter.restful.v1.models.ProviderAdapterDTO;
import net.unir.proveedores.domain.entities.ProviderDomainDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdapterProviderMapper {
    ProviderAdapterDTO fromDomainToAdapter(ProviderDomainDTO domainDTO);
    ProviderDomainDTO fromAdapterToDomain(ProviderAdapterDTO adapterDTO);

    List<ProviderAdapterDTO> fromDomainToAdapterList(List<ProviderDomainDTO> providerDomainDTOList);

    List<ProviderDomainDTO> fromAdapterToDomainList(List<ProviderAdapterDTO> adapterDTOList);
}
