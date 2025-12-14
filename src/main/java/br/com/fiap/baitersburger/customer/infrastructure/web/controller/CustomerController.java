package br.com.fiap.baitersburger.customer.infrastructure.web.controller;

import br.com.fiap.baitersburger.customer.application.service.CustomerService;
import br.com.fiap.baitersburger.customer.domain.exception.CustomerNotFoundException;
import br.com.fiap.baitersburger.customer.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.customer.domain.model.Customer;
import br.com.fiap.baitersburger.customer.domain.port.in.GetCustomerByCpfUserCase;
import br.com.fiap.baitersburger.customer.domain.port.in.InsertCustomerUseCase;
import br.com.fiap.baitersburger.customer.infrastructure.web.dto.CustomerRequestDTO;
import br.com.fiap.baitersburger.customer.infrastructure.web.dto.CustomerResponseDTO;
import br.com.fiap.baitersburger.customer.infrastructure.web.mapper.CustomerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerUseCase insertCustomerUseCase;
    private final GetCustomerByCpfUserCase getCustomerByCpfUserCase;
    private final CustomerMapper customerMapper;

    public CustomerController(InsertCustomerUseCase insertCustomerUseCase,
                              GetCustomerByCpfUserCase getCustomerByCpfUserCase,
                              CustomerMapper customerMapper) {
        this.insertCustomerUseCase = insertCustomerUseCase;
        this.getCustomerByCpfUserCase = getCustomerByCpfUserCase;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CustomerRequestDTO customerRequestDTO) {
        var customer = customerMapper.toCustomer(customerRequestDTO);
        insertCustomerUseCase.insert(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CustomerResponseDTO> get(@PathVariable String cpf) {
        var customer = getCustomerByCpfUserCase.findByCpf(cpf);
        var customerResponseDTO = customerMapper.toCustomerResponseDTO(customer);
        return ResponseEntity.ok().body(customerResponseDTO);
    }
}
