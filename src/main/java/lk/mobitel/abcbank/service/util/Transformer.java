package lk.mobitel.abcbank.service.util;

import lk.mobitel.abcbank.dto.CustomerDTO;
import lk.mobitel.abcbank.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {
    private final ModelMapper mapper;

    public Transformer(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Customer fromCustomerDTO(CustomerDTO customerDTO){
        return mapper.map(customerDTO, Customer.class);
    }
    public CustomerDTO toCustomerDTO(Customer customer){
        return mapper.map(customer, CustomerDTO.class);
    }
}
