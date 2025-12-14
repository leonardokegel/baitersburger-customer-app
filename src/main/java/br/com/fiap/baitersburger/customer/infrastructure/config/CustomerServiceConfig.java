package br.com.fiap.baitersburger.customer.infrastructure.config;

import br.com.fiap.baitersburger.customer.application.service.CustomerService;
import br.com.fiap.baitersburger.customer.domain.port.in.GetCustomerByCpfUserCase;
import br.com.fiap.baitersburger.customer.domain.port.in.InsertCustomerUseCase;
import br.com.fiap.baitersburger.customer.domain.port.out.CustomerRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerServiceConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(CustomerRepositoryPort customerRepositoryPort) {
        return new CustomerService(customerRepositoryPort);
    }

    @Bean
    public GetCustomerByCpfUserCase getCustomerByCpfUserCase(CustomerRepositoryPort customerRepositoryPort) {
        return new CustomerService(customerRepositoryPort);
    }

}
