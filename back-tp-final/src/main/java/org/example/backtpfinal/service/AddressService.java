package org.example.backtpfinal.service;

import org.example.backtpfinal.entities.Address;
import org.example.backtpfinal.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IBaseService<Address>{
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address element) {
        return addressRepository.save(element);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(Long id) {
        return addressRepository.getById(id);
    }

    @Override
    public Address update(Address element) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
