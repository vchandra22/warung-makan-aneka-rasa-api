package com.warung_makan.aneka_rasa.controller;

import com.warung_makan.aneka_rasa.constant.Constant;
import com.warung_makan.aneka_rasa.dto.request.CustomerRequest;
import com.warung_makan.aneka_rasa.dto.response.CustomerResponse;
import com.warung_makan.aneka_rasa.service.CustomerService;
import com.warung_makan.aneka_rasa.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = Constant.CUSTOMER_API)
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequest request) {
        CustomerResponse customerResponse = customerService.createCustomer(request);

        return ResponseUtil.buildResponse(HttpStatus.CREATED, Constant.SUCCESS_CREATE_CUSTOMER, customerResponse);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable String id) {
        CustomerResponse customerResponse = customerService.getCustomerById(id);

        return ResponseUtil.buildResponse(HttpStatus.OK, Constant.SUCCESS_GET_CUSTOMER, customerResponse);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable String id, @RequestBody CustomerRequest request) {
        CustomerResponse customerResponse = customerService.updateCustomer(id, request);

        return ResponseUtil.buildResponse(HttpStatus.OK, Constant.SUCCESS_UPDATE_CUSTOMER, customerResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        List<CustomerResponse> customerResponseList = customerService.getAllCustomers();

        return ResponseUtil.buildResponse(HttpStatus.OK, Constant.SUCCESS_GET_ALL_CUSTOMER, customerResponseList);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);

        return ResponseUtil.buildResponse(HttpStatus.OK, Constant.SUCCESS_DELETE_CUSTOMER, null);
    }
}
