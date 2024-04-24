package org.example.backtpfinal.controller;

import org.example.backtpfinal.dto.AddressDTO;
import org.example.backtpfinal.entities.Address;
import org.example.backtpfinal.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/address")
public class AddressController {

   private AddressService addressService;
   @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add")
    public ResponseEntity<Address> addNewAddress (@RequestBody AddressDTO dto){
        Address newAddress = addressService.save(dto);
        System.out.println("add address");
        return new ResponseEntity<>(newAddress, HttpStatus.CREATED);

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
    public Optional<Address> getAddressById (@PathVariable Long id) {
        System.out.println("methode");

       // try{
            Optional<Address> address = addressService.getById(id);
            System.out.println(address);
           return address;
       // return new Address(58L,24,"test","test2","zip","town","udfhudh",new ArrayList<>());
       // }catch (Exception e){
        //    return null;
       // }
    }

    @GetMapping("/test")
    public  Address getTest () {

        //return new Address(58L,24,"test","test2","zip","town","udfhudh",new ArrayList<>());
        return new Address(58L,24,"test","test2","zip","town","udfhudh",null);
    }

}
