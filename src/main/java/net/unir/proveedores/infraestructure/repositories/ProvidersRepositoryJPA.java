package net.unir.proveedores.infraestructure.repositories;

import net.unir.proveedores.infraestructure.entities.ProvidersJPA;
import org.springframework.data.repository.CrudRepository;

public interface ProvidersRepositoryJPA extends CrudRepository<ProvidersJPA, Long> {
}
