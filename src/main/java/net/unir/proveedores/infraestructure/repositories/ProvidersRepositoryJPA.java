package net.unir.proveedores.infraestructure.repositories;

import net.unir.proveedores.infraestructure.entities.ProvidersJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProvidersRepositoryJPA extends JpaRepository<ProvidersJPA, Long>, JpaSpecificationExecutor<ProvidersJPA> {
}
