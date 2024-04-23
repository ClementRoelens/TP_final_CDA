package org.example.backtpfinal.controller;

import org.example.backtpfinal.dto.AddressDTO;
import org.example.backtpfinal.entities.Address;
import org.example.backtpfinal.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/api/address")
public class AddressController {

   private AddressService addressService;
   @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<Address> addNewAddress (@RequestBody AddressDTO dto){
        Address address = new Address();
        address.setComplement(dto.getComplement());
        address.setNumber(dto.getNumber());
        address.setStreet(dto.getStreet());
        address.setZipCode(dto.getZipCode());
        address.setTown(dto.getTown());
        address.setCountry(dto.getCountry());;
        Address newAdd = addressService.save(address);
        System.out.println("add");
        return  ResponseEntity.ok(newAdd);

    }

    /*@PostMapping
    public  Address addNewAddress (@RequestBody Address address){
        System.out.println("add");
        return addressService.save(address);

    }*/
//    @GetMapping("/{id}")
//    public  ResponseEntity<Address> getAddressById (@PathVariable Long id){
//
//
//       try{
//           Address address = addressService.getById(id);
//
//           return  ResponseEntity.ok(address);
//       }catch (Exception e){
//           return ResponseEntity.notFound().build();
//       }
//    }

    @GetMapping("/{id}")
    public  Address getAddressById (@PathVariable Long id) {
        System.out.println("methode");

       // try{
            Address address = addressService.getById(id);
            System.out.println(address);
           // return address;
        return new Address(58L,24,"test","test2","zip","town","udfhudh",new ArrayList<>());
       // }catch (Exception e){
        //    return null;
       // }
    }

    @GetMapping("/test")
    public  Address getTest () {

        return new Address(58L,24,"test","test2","zip","town","udfhudh",new ArrayList<>());
    }

}
