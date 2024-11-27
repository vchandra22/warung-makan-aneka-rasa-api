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

    private CustomerResponse toCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .email(customer.getEmail())
                .build();
    }

}
