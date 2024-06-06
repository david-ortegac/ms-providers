package net.unir.proveedores.adapter.restful.v1.models;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageAndFilterParams {

    @NotNull
    private int page;

    @NotNull
    private int size;

    private String filterParams;
}
