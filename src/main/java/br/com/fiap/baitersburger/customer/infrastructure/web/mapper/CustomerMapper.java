package br.com.fiap.baitersburger.customer.infrastructure.web.mapper;

import br.com.fiap.baitersburger.customer.domain.model.Customer;
import br.com.fiap.baitersburger.customer.infrastructure.web.dto.CustomerRequestDTO;
import br.com.fiap.baitersburger.customer.infrastructure.web.dto.CustomerResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO toCustomerResponseDTO(Customer customer);
}
