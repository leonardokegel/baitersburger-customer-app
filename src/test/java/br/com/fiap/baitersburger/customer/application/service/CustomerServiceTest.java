package br.com.fiap.baitersburger.customer.application.service;

import br.com.fiap.baitersburger.customer.domain.exception.CustomerAlreadyExistsException;
import br.com.fiap.baitersburger.customer.domain.exception.CustomerNotFoundException;
import br.com.fiap.baitersburger.customer.domain.exception.InvalidCpfException;
import br.com.fiap.baitersburger.customer.domain.model.Customer;
import br.com.fiap.baitersburger.customer.domain.port.out.CustomerRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepositoryPort customerRepositoryPort;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void shouldInsertCustomerSuccessfully() {
        Customer customer = new Customer("Leonardo", "14555239091", "teste@teste.com");
        when(customerRepositoryPort.findByCpf(customer.getCpf()))
                .thenReturn(Optional.empty());

        doNothing().when(customerRepositoryPort).insert(customer);

        customerService.insert(customer);

        verify(customerRepositoryPort).findByCpf(customer.getCpf());
        verify(customerRepositoryPort).insert(customer);
    }

    @Test
    void shouldReturnCustomerWhenCpfExists() {
        String cpf = "87662309002";
        Customer customer = new Customer("João", cpf, "joao@email.com");

        when(customerRepositoryPort.findByCpf(cpf)).thenReturn(Optional.of(customer));

        Customer result = customerService.findByCpf(cpf);

        assertEquals(customer, result);
    }

    @Test
    void shouldThrowExceptionWhenCpfNotFound() {
        String cpf = "87662309002";

        when(customerRepositoryPort.findByCpf(cpf)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> customerService.findByCpf(cpf));
    }

    @Test
    void givenExistingCustomer_whenInsert_thenThrowException() {
        Customer customer = new Customer("Teste", "51828853003", "teste2@teste.com");

        BDDMockito.given(customerRepositoryPort.findByCpf(customer.getCpf()))
                .willReturn(Optional.of(customer));

        assertThrows(CustomerAlreadyExistsException.class,
                () -> customerService.insert(customer));

        BDDMockito.then(customerRepositoryPort).should(never()).insert(customer);
    }

    @Test
    void givenExistingCustomer_whenFindByCpf_thenReturnCustomer() {
        Customer customer = new Customer("Carlos", "89661608083", "c@email.com");

        BDDMockito.given(customerRepositoryPort.findByCpf("89661608083"))
                .willReturn(Optional.of(customer));

        Customer result = customerService.findByCpf("89661608083");

        BDDMockito.then(customerRepositoryPort).should().findByCpf("89661608083");
        assertEquals(customer, result);
    }

    @Test
    void givenNonExistingCustomer_whenFindByCpf_thenThrowException() {
        BDDMockito.given(customerRepositoryPort.findByCpf("000"))
                .willReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class,
                () -> customerService.findByCpf("000"));
    }

}
