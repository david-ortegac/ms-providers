package net.unir.proveedores.adapter.restful.v1.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderAdapterDTO {
    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String email;
}
