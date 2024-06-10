package net.unir.proveedores.adapter.restful.v1.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderAdapterDTO {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String address;
    @NotNull
    private String phone;

    @NotNull
    @Email
    private String email;

}
