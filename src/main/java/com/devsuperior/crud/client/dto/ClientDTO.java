package com.devsuperior.crud.client.dto;

import com.devsuperior.crud.client.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;
    @Size(min = 3, max = 80, message = "Nome  precisar  ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    private String cpf;
    private Double income;
    @PastOrPresent(message = "Não pode ser data futura")
    private LocalDate birthDate;
    private Integer childrean;

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer childrean) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.childrean = childrean;
    }
    public ClientDTO(Client entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.cpf = entity.getCpf();
        this.income = entity.getIncome();
        this.birthDate = entity.getBirthDate();
        this.childrean = entity.getChildrean();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildrean() {
        return childrean;
    }
}
