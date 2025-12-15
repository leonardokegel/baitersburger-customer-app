package br.com.fiap.baitersburger.customer.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    void shouldCreateCustomerWithAllFields() {
        Customer customer = new Customer(
                "João",
                "12345678900",
                "joao@email.com"
        );

        assertAll(
                () -> assertEquals("João", customer.getName()),
                () -> assertEquals("12345678900", customer.getCpf()),
                () -> assertEquals("joao@email.com", customer.getEmail())
        );
    }

    @Test
    void shouldUpdateCustomerFields() {
        Customer customer = new Customer(
                "João",
                "12345678900",
                "joao@email.com"
        );

        customer.setName("Maria");
        customer.setCpf("09876543211");
        customer.setEmail("maria@email.com");

        assertAll(
                () -> assertEquals("Maria", customer.getName()),
                () -> assertEquals("09876543211", customer.getCpf()),
                () -> assertEquals("maria@email.com", customer.getEmail())
        );
    }
}
