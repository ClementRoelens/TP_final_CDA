package org.example.backtpfinal.exception;

import java.util.UUID;

public class AddressNotFound extends RuntimeException{
    public AddressNotFound(UUID addressId){
        super("Address not found with id:  " + addressId);
    }
}
