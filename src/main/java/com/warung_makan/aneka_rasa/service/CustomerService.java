package com.warung_makan.aneka_rasa.service;

import com.warung_makan.aneka_rasa.dto.request.CustomerRequest;
import com.warung_makan.aneka_rasa.dto.response.CustomerResponse;
import com.warung_makan.aneka_rasa.entity.Customer;

import java.util.List;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest customerRequest);
    CustomerResponse getCustomerById(String id);
    CustomerResponse updateCustomer(String id, CustomerRequest customerRequest);
    Customer getOne(String id);
    List<CustomerResponse> getAllCustomers();
    void deleteCustomer(String id);
}
