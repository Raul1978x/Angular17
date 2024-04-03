package com.recursospropios.facturacion.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "social-security")
public class SocialSecurity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rnos", nullable = false)
//    private Long userPatientId;

    private Long rnos;

    private String companyName;
    private String initials;
    private String address;
    private String web;
    private String zipCode;
    private String province;
    private String city;
    private String cuit;
    private String iva;

}
