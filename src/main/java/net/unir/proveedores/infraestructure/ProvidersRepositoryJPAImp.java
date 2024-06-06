package net.unir.proveedores.infraestructure;

import io.github.perplexhub.rsql.RSQLSupport;
import net.unir.proveedores.domain.ProvidersRepositoryDomain;
import net.unir.proveedores.domain.entities.ProviderDomainDTO;
import net.unir.proveedores.infraestructure.entities.ProvidersJPA;
import net.unir.proveedores.infraestructure.mappers.InfraestructureMapper;
import net.unir.proveedores.infraestructure.repositories.ProvidersRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProvidersRepositoryJPAImp implements ProvidersRepositoryDomain {

    private Pageable pageable = PageRequest.of(0, 5); //page 1 and page size is 5

    @Autowired
    private ProvidersRepositoryJPA repositoryJPA;

    @Autowired
    private InfraestructureMapper mapper;

    @Override
    public Long getProvidersCount() {
        return repositoryJPA.count();
    }

    @Override
    public List<ProviderDomainDTO> getAll(String filter) {
        String filter2 = "id=bt=(2,4)";
        Page<ProvidersJPA> providersJPA = repositoryJPA.findAll(pageable);
        return mapper.toDomainList(providersJPA);
    }

    @Override
    public ProviderDomainDTO getById(Long id) {
        Optional<ProvidersJPA> getById = repositoryJPA.findById(id);
        return mapper.toDomain(getById.orElseThrow());
    }

    @Override
    public ProviderDomainDTO save(ProviderDomainDTO domainDTO) {
        return mapper.toDomain(repositoryJPA.save(mapper.fromDomain(domainDTO)));
    }

    @Override
    public ProviderDomainDTO delete(Long id) {
        Optional<ProvidersJPA> deleted = repositoryJPA.findById(id);
        repositoryJPA.deleteById(id);
        return mapper.toDomain(deleted.orElseThrow());
    }
}
