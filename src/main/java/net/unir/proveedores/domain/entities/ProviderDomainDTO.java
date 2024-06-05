package net.unir.proveedores.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderDomainDTO {
    public Long id;
    public String name;
    public String lastName;
    public String address;
    public String phone;
    public String email;
}
