package net.unir.proveedores.aplication;

import net.unir.proveedores.adapter.restful.v1.mappers.AdapterProviderMapper;
import net.unir.proveedores.adapter.restful.v1.models.ProviderAdapterDTO;
import net.unir.proveedores.domain.ProvidersRepositoryDomain;
import net.unir.proveedores.domain.entities.ProviderDomainDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ApplicationServiceProvidersImpl implements ApplicationServiceProvider {

    @Autowired
    private ProvidersRepositoryDomain repositoryDomain;

    @Autowired
    private AdapterProviderMapper mapper;

    @Override
    public ProviderDomainDTO getProvidersById(Long id) {
        return repositoryDomain.getById(id);
    }

    @Override
    public List<ProviderAdapterDTO> getAll(String name, String LastName, String address, String email, String phone) {
        if (StringUtils.hasLength(name)
                || StringUtils.hasLength(LastName)
                || StringUtils.hasLength(address)
                || StringUtils.hasLength(email)
                || StringUtils.hasLength(phone)) {
            return mapper.fromDomainToAdapterList(repositoryDomain.search(name, LastName, address, email, phone));
        }
        return mapper.fromDomainToAdapterList(repositoryDomain.getAll());
    }

    @Override
    public ProviderDomainDTO saveProvider(ProviderAdapterDTO adapterDTO) throws Exception {
        if (StringUtils.hasLength(adapterDTO.getName())
                && StringUtils.hasLength(adapterDTO.getLastName())
                && StringUtils.hasLength(adapterDTO.getAddress())
                && StringUtils.hasLength(adapterDTO.getPhone())
                && StringUtils.hasLength(adapterDTO.getEmail())
        ) {
            return repositoryDomain.save(mapper.fromAdapterToDomain(adapterDTO));
        } else {
            throw new Exception("Datos faltantes");
        }
    }

    @Override
    public ProviderDomainDTO updateProvider(Long id, ProviderAdapterDTO adapterDTO) {
        ProviderDomainDTO provider = this.getProvidersById(id);
        adapterDTO.setId(id);
        if(null != adapterDTO.getName()) {
            provider.setName(adapterDTO.getName());
        }
        if(null != adapterDTO.getLastName()) {
            provider.setLastName(adapterDTO.getLastName());
        }
        if(null != adapterDTO.getAddress()) {
            provider.setAddress(adapterDTO.getAddress());
        }
        if(null != adapterDTO.getPhone()) {
            provider.setPhone(adapterDTO.getPhone());
        }
        if(null != adapterDTO.getEmail()) {
            provider.setEmail(adapterDTO.getEmail());
        }

        return repositoryDomain.save(mapper.fromAdapterToDomain(mapper.fromDomainToAdapter(provider)));
    }

    @Override
    public ProviderDomainDTO deleteProvider(Long id) {
        return repositoryDomain.delete(id);
    }
}
