package net.unir.proveedores.adapter.restful.v1.models;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class ProviderAdapterDTO {

    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    @Email
    private String email;

}
