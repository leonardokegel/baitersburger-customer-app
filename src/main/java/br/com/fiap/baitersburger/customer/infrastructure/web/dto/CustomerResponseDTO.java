package br.com.fiap.baitersburger.customer.infrastructure.web.dto;

import lombok.Data;

@Data
public class CustomerResponseDTO {

    private String cpf;
    private String name;
    private String email;

}
