package br.com.fiap.baitersburger.customer.domain.model;

import br.com.fiap.baitersburger.customer.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.customer.domain.exception.InvalidCpfException;

public class Customer {

    private String name;
    private String cpf;
    private String email;

    public Customer(String name, String cpf, String email) {

        if (cpf == null || cpf.isBlank()) {
            throw new InvalidCpfException(ExceptionMessages.CPF_NOT_BE_BLANK_OR_NULL);
        }

        this.name = name;
        this.cpf = cpf;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
