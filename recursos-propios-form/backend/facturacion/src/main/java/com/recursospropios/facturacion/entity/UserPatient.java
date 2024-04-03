package com.recursospropios.facturacion.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "user-patient")
public class UserPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long dni;
    private String nombre;
    private String apellido;
    private String tipo;
    private Integer cantidad;
    private Double codigo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Long rnos;

    @ManyToOne
    @JoinColumn(name = "rnos", insertable = false, updatable = false)
    private SocialSecurity socialSecurity;
}
