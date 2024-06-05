package net.unir.proveedores.infraestructure;

import net.unir.proveedores.adapter.restful.v1.models.ProviderAdapterDTO;
import net.unir.proveedores.domain.ProvidersRepositoryDomain;
import net.unir.proveedores.domain.entities.ProviderDomainDTO;
import net.unir.proveedores.infraestructure.entities.ProvidersJPA;
import net.unir.proveedores.infraestructure.mappers.InfraestructureMapper;
import net.unir.proveedores.infraestructure.repositories.ProvidersRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProvidersRepositoryJPAImp implements ProvidersRepositoryDomain {

    @Autowired
    private ProvidersRepositoryJPA repositoryJPA;

    @Autowired
    private InfraestructureMapper mapper;

    @Override
    public Long getProvidersCount() {
        return repositoryJPA.count();
    }

    @Override
    public List<ProviderDomainDTO> getAll() {
        Iterable<ProvidersJPA> providersJPA = repositoryJPA.findAll();
        return mapper.toDomainList(providersJPA);
    }

    @Override
    public ProviderDomainDTO getById(Long id) {
        Optional<ProvidersJPA> getById = repositoryJPA.findById(id);
        return mapper.toDomain(getById.orElseThrow());
    }

    @Override
    public ProviderDomainDTO save(ProviderAdapterDTO adapterDTO) {
        //return mapper.toDomain(repositoryJPA.save(adapterDTO));
        return null;
    }

    @Override
    public ProviderDomainDTO update() {
        return null;
    }

    @Override
    public ProviderDomainDTO delete(Long id) {
        Optional<ProvidersJPA> deleted = repositoryJPA.findById(id);
        repositoryJPA.deleteById(id);
        return mapper.toDomain(deleted.orElseThrow());
    }
}
