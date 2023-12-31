package org.malibu.inventario.modelo;

import java.math.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import org.malibu.inventario.ValidacionEntradas.ValidFileExtension;

import org.openxava.annotations.*;

import lombok.*;
@Entity
@Getter
@Setter
public class Producto {

    @Id
    @Column(length = 9,name = "codigo") // Cambia el nombre del atributo
    int codigo; // Cambia el nombre del atributo

    @Column(length = 50)
    @Required
    String descripcion;

    @Column(length = 9)
    @PositiveOrZero
    int stock;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @DescriptionsList
    Category nombreCategoriaDescripcion;


    @Money
    @PositiveOrZero
    @NotNull(message = "El precio no puede quedar VACIO")
    BigDecimal precio;

    @File
    @Column(length = 32)
    String fotos;


    @TextArea
    @Pattern(regexp = "^[a-zA-Z]+([\\s\\-][a-zA-Z]+)*$", message = "Las observaciones solo debe contener letras y espacios")
    String observaciones;

}
