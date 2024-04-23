package org.example.backtpfinal.controller;

import org.example.backtpfinal.entities.Address;
import org.example.backtpfinal.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {
   private AddressService addressService;
   @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

   

}
