package net.unir.proveedores.adapter.restful.v1.rest;

import net.unir.proveedores.adapter.restful.v1.mappers.AdapterProviderMapper;
import net.unir.proveedores.adapter.restful.v1.models.ProviderAdapterDTO;
import net.unir.proveedores.aplication.ApplicationServiceProvidersImpl;
import net.unir.proveedores.domain.entities.ProviderDomainDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedores/")
public class RestfulAdapterProviders {

    @Autowired
    private AdapterProviderMapper mapper;

    @Autowired
    private ApplicationServiceProvidersImpl serviceProviders;

    @GetMapping("{id}")
    public ProviderAdapterDTO getProvidersById(@PathVariable Long id) {
        return mapper.fromDomainToAdapter(serviceProviders.getProvidersById(id));
    }

    @GetMapping("count")
    public Long getCountAllProviders() {
        return serviceProviders.getCountProviders();
    }

    @GetMapping
    public List<ProviderAdapterDTO> getAllProviders() {
        return mapper.fromDomainToAdapterList(mapper.fromAdapterToDomainList(serviceProviders.getAll()));
    }

    @PostMapping("/")
    public ProviderAdapterDTO save(@RequestBody ProviderAdapterDTO adapterDTO){
        return mapper.fromDomainToAdapter(serviceProviders.saveProvider(adapterDTO));
    }

    @DeleteMapping("{id}")
    public ProviderAdapterDTO save(@PathVariable Long id){
        return mapper.fromDomainToAdapter(serviceProviders.deleteProvider(id));
    }
}
