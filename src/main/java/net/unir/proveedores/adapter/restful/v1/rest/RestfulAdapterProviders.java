package net.unir.proveedores.adapter.restful.v1.rest;

import jakarta.validation.Valid;
import net.unir.proveedores.adapter.restful.v1.mappers.AdapterProviderMapper;
import net.unir.proveedores.adapter.restful.v1.models.ProviderAdapterDTO;
import net.unir.proveedores.aplication.ApplicationServiceProvidersImpl;
import net.unir.proveedores.domain.entities.ProviderDomainDTO;
import org.apache.http.protocol.ResponseContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedores/")
public class RestfulAdapterProviders {

    @Autowired
    private AdapterProviderMapper mapper;

    @Autowired
    private ApplicationServiceProvidersImpl serviceProviders;

    @GetMapping("{id}")
    public ResponseEntity<ProviderAdapterDTO> getProvidersById(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(mapper.fromDomainToAdapter(serviceProviders.getProvidersById(id)), HttpStatus.OK);
    }

    @GetMapping("count")
    public ResponseEntity<Long> getCountAllProviders() {
        return new ResponseEntity<>(serviceProviders.getCountProviders(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProviderAdapterDTO>> getAllProviders() {
        return new ResponseEntity<>(mapper.fromDomainToAdapterList(mapper.fromAdapterToDomainList(serviceProviders.getAll())), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProviderAdapterDTO> save(@Valid @RequestBody ProviderAdapterDTO adapterDTO){
        return new ResponseEntity<>(mapper.fromDomainToAdapter(serviceProviders.saveProvider(adapterDTO)), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProviderAdapterDTO> save(@PathVariable Long id, @RequestBody ProviderAdapterDTO adapterDTO){
        return new ResponseEntity<>(mapper.fromDomainToAdapter(serviceProviders.updateProvider(id, adapterDTO)), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ProviderAdapterDTO> delete(@PathVariable Long id){
        return new ResponseEntity<>(mapper.fromDomainToAdapter(serviceProviders.deleteProvider(id)), HttpStatus.OK);
    }
}
