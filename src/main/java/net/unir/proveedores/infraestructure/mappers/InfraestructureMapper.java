package net.unir.proveedores.infraestructure.mappers;

import net.unir.proveedores.domain.entities.ProviderDomainDTO;
import net.unir.proveedores.infraestructure.entities.ProvidersJPA;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InfraestructureMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "lastName", source = "lastName"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "phone", source = "phone"),
            @Mapping(target = "email", source = "email")
    })
    ProviderDomainDTO toDomain(ProvidersJPA item);

    List<ProviderDomainDTO> toDomainList(Iterable<ProvidersJPA> items);

    ProvidersJPA fromDomain(ProviderDomainDTO item, @MappingTarget ProvidersJPA jpa);
}
