package br.com.fiap.baitersburger.customer.infrastructure.mapper;


import br.com.fiap.baitersburger.customer.domain.model.Customer;
import br.com.fiap.baitersburger.customer.infrastructure.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    Customer toCustomer(CustomerEntity customerEntity);
    CustomerEntity toCustomerEntity(Customer customer);

}
