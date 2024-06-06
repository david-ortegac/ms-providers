package net.unir.proveedores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = { "net.unir.proveedores.infraestructure.repositories" })
@EnableTransactionManagement
@EntityScan(basePackages = "net.unir.proveedores.infraestructure.entities")
@SpringBootApplication
public class ProveedoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProveedoresApplication.class, args);
	}

}
