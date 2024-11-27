package com.warung_makan.aneka_rasa.service;

import com.warung_makan.aneka_rasa.dto.request.CustomerRequest;
import com.warung_makan.aneka_rasa.dto.response.CustomerResponse;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest customerRequest);
}
