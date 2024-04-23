package org.example.backtpfinal.service;

import org.example.backtpfinal.dto.AddressDTO;
import org.example.backtpfinal.entities.Address;
import org.example.backtpfinal.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IBaseService<Address>{
    @Autowired
    private AddressRepository addressRepository;


    public Address save(AddressDTO dto) {
        Address address = Address
                .builder()
                .number(dto.getNumber())
                .street(dto.getStreet())
                .complement(dto.getComplement())
                .zipCode(dto.getZipCode())
                .town(dto.getTown())
                .country(dto.getCountry())
                .build();
        return addressRepository.save(address);
    }


    @Override
    public Address save(Address element) {
        return null;
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getById(Long id) {
        return addressRepository.findAddressById(id);
    }

    @Override
    public Address update(Address element) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
