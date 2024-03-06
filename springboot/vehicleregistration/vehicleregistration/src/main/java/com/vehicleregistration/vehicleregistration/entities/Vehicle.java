package com.vehicleregistration.vehicleregistration.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

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

    public  Vehicle(){

    }

    public  Vehicle(String veiculo, String marca, String cor, Integer ano){
        this.veiculo = veiculo;
        this.marca = marca;
        this.cor = cor;
        this.ano = ano;


        this.created = new Date();
        this.update = new Date();
    }

    public  String getVeiculo(){ return  veiculo; }
    public  void setVeiculo(String value){ veiculo = value; }
    public UUID getId(){
        return  id;
    }
    public String getMarca() {
        return this.marca;
    }
    public  void setMarca(String value){ marca = value; }
    public  String getCor(){
        return this.cor;
    }
    public  void setCor(String value){ cor = value; }
    public Integer getAno() {
        return  this.ano;
    }
    public  void setAno(Integer value){ ano = value; }

    public  Vehicle get(){
        return  this;
    }
}
