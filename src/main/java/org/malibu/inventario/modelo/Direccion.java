package org.malibu.inventario.modelo;


import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

import lombok.*;

@Embeddable
@Getter
@Setter
public class Direccion {

    @Column(length = 30)
    String urbanizacion;

    @Column(length = 1)
    String manzana;

    @Column(length = 2)
    int lote;

    @Column(length = 20)
    String distrito;

    @Column(length = 30)
    String provincia;

    @PrePersist
    @PreUpdate
    private void validarDireccion() {
        if (urbanizacion != null && !urbanizacion.matches("^[A-Za-z]+$")) {
            throw new IllegalArgumentException("La urbanización debe contener solo letras");
        }
        if (distrito != null && !distrito.matches("^[A-Za-z]+$")) {
            throw new IllegalArgumentException("El distrito debe contener solo letras");
        }
        if (provincia != null && !provincia.matches("^[A-Za-z]+$")) {
            throw new IllegalArgumentException("La provincia debe contener solo letras");
        }
        if (manzana != null && !manzana.matches("^[A-Za-z]$")) {
            throw new IllegalArgumentException("La manzana debe ser una letra");
        }
    }


}
