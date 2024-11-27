package com.warung_makan.aneka_rasa.controller;

import com.warung_makan.aneka_rasa.constant.Constant;
import com.warung_makan.aneka_rasa.dto.request.CustomerRequest;
import com.warung_makan.aneka_rasa.dto.response.CustomerResponse;
import com.warung_makan.aneka_rasa.service.CustomerService;
import com.warung_makan.aneka_rasa.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = Constant.CUSTOMER_API)
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.createCustomer(customerRequest);

        return ResponseUtil.buildResponse(HttpStatus.CREATED, Constant.SUCCESS_CREATE_CUSTOMER, customerResponse);
    }
}
