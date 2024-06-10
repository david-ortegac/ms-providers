package net.unir.proveedores.infraestructure;

import io.micrometer.common.util.StringUtils;
import net.unir.proveedores.aplication.utils.SearchCriteria;
import net.unir.proveedores.aplication.utils.SearchOperation;
import net.unir.proveedores.aplication.utils.SearchStatement;
import net.unir.proveedores.domain.ProvidersRepositoryDomain;
import net.unir.proveedores.domain.entities.ProviderDomainDTO;
import net.unir.proveedores.infraestructure.entities.ProvidersJPA;
import net.unir.proveedores.infraestructure.mappers.InfraestructureMapper;
import net.unir.proveedores.infraestructure.repositories.ProvidersRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<ProviderDomainDTO> getAll() {
        Page<ProvidersJPA> providersJPA = repositoryJPA.findAll(pageable);
        return mapper.toDomainList(providersJPA);
    }

    @Override
    public List<ProviderDomainDTO> search(String name, String lastName, String address, String email, String phone) {
        SearchCriteria<ProvidersJPA> spec = new SearchCriteria<>();
        if(StringUtils.isNotBlank(name)){
            spec.add(new SearchStatement("name", name, SearchOperation.MATCH));
        }
        if(StringUtils.isNotBlank(lastName)){
            spec.add(new SearchStatement("lastName", lastName, SearchOperation.MATCH));
        }
        if(StringUtils.isNotBlank(address)){
            spec.add(new SearchStatement("address", address, SearchOperation.MATCH));
        }
        if(StringUtils.isNotBlank(email)){
            spec.add(new SearchStatement("email", email, SearchOperation.MATCH));
        }
        if(StringUtils.isNotBlank(phone)){
            spec.add(new SearchStatement("phone", phone, SearchOperation.MATCH));
        }

        return mapper.toDomainList(repositoryJPA.findAll(spec));
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
