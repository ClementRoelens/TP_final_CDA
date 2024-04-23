package org.example.backtpfinal.exception;

import java.util.UUID;

public class AddressNotFound extends RuntimeException{
    public AddressNotFound(Long addressId){
        super("Address not found with id:  " + addressId);
    }
}
