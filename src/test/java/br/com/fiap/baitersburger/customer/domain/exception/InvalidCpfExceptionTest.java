package br.com.fiap.baitersburger.customer.domain.exception;

import br.com.fiap.baitersburger.customer.domain.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InvalidCpfExceptionTest {

    @Test
    void shouldThrowExceptionWhenCpfIsNull() {
        assertThrows(InvalidCpfException.class,
                () -> new Customer("João", null, "joao@email.com"));
    }

    @Test
    void shouldThrowExceptionWhenCpfIsBlank() {
        assertThrows(InvalidCpfException.class,
                () -> new Customer("João", " ", "joao@email.com"));
    }

}
