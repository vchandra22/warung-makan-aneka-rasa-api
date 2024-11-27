package com.warung_makan.aneka_rasa.service;

import com.warung_makan.aneka_rasa.dto.request.CustomerRequest;
import com.warung_makan.aneka_rasa.dto.response.CustomerResponse;
import com.warung_makan.aneka_rasa.entity.Customer;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest customerRequest);
    CustomerResponse getCustomerById(String id);
    Customer getOne(String id);
    CustomerResponse updateCustomer(String id, CustomerRequest customerRequest);
}
