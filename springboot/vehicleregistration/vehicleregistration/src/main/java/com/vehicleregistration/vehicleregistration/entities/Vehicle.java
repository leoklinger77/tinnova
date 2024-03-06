package com.vehicleregistration.vehicleregistration.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_Vehicle")
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String veiculo;
    private String marca;
    private String cor;
    private Integer ano;
    private String descricao;
    private Boolean vendido;
    private Date created;
    private Date update;


    public  Vehicle(String veiculo, String marca, String cor, Integer ano){
        this.veiculo = veiculo;
        this.marca = marca;
        this.cor = cor;
        this.ano = ano;
    }

    public UUID getId(){
        return  id;
    }
    public String getMarca() {
        return this.marca;
    }
    public  String getCor(){
        return this.cor;
    }
    public Integer getAno() {
        return  this.ano;
    }
}
