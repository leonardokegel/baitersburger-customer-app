package br.com.fiap.baitersburger.customer.domain.port.out;

import br.com.fiap.baitersburger.customer.domain.model.Customer;

import java.util.Optional;

public interface CustomerRepositoryPort {

    void insert(Customer customer);

    Optional<Customer> findByCpf(String cpf);

}
