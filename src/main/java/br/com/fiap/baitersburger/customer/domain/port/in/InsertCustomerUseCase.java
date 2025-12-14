package br.com.fiap.baitersburger.customer.domain.port.in;

import br.com.fiap.baitersburger.customer.domain.model.Customer;

public interface InsertCustomerUseCase {

    void insert(Customer customer);

}
