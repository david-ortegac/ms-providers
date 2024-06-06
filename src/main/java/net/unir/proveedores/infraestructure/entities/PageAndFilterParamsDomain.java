package net.unir.proveedores.infraestructure.entities;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageAndFilterParamsDomain {

    @NotNull
    private int page;

    @NotNull
    private int size;

    private String filterParams;
}
