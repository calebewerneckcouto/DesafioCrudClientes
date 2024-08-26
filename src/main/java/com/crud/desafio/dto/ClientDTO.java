package com.crud.desafio.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;

public class ClientDTO {

    private Long id;

    @NotEmpty(message = "Nome não pode ser vazio")
    private String name;

    @NotEmpty(message = "CPF não pode ser vazio")
    private String cpf;

    @NotNull(message = "Renda não pode ser nula")
    private Double income;

    @PastOrPresent(message = "Data de nascimento não pode ser no futuro")
    private LocalDate birthDate;

    @NotNull(message = "Quantidade de filhos não pode ser nula")
    private Integer children;

    // Default constructor
    public ClientDTO() {
    }

    // Parameterized constructor
    public ClientDTO(Long id, @NotEmpty(message = "Nome não pode ser vazio") String name,
                     @NotEmpty(message = "CPF não pode ser vazio") String cpf,
                     @NotNull(message = "Renda não pode ser nula") Double income,
                     @PastOrPresent(message = "Data de nascimento não pode ser no futuro") LocalDate birthDate,
                     @NotNull(message = "Quantidade de filhos não pode ser nula") Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ClientDTO other = (ClientDTO) obj;
        return Objects.equals(id, other.id);
    }
}
