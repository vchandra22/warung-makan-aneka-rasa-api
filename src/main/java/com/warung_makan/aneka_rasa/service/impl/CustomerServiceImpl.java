package com.warung_makan.aneka_rasa.service.impl;

import com.warung_makan.aneka_rasa.dto.request.CustomerRequest;
import com.warung_makan.aneka_rasa.dto.response.CustomerResponse;
import com.warung_makan.aneka_rasa.entity.Customer;
import com.warung_makan.aneka_rasa.repository.CustomerRepository;
import com.warung_makan.aneka_rasa.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .phoneNumber(customerRequest.getPhoneNumber())
                .email(customerRequest.getEmail())
                .build();

        customerRepository.saveAndFlush(customer);

        return toCustomerResponse(customer);
    }

    @Override
    public CustomerResponse getCustomerById(String id) {
        Customer customer = getOne(id);

        return toCustomerResponse(customer);
    }

    @Override
    public Customer getOne(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public CustomerResponse updateCustomer(String id, CustomerRequest customerRequest) {
        Customer customer = getOne(id);

        customer.setName(customerRequest.getName());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        customer.setEmail(customerRequest.getEmail());

        return toCustomerResponse(customer);
    }

    private CustomerResponse toCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .email(customer.getEmail())
                .build();
    }

}
