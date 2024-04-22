package org.example.backtpfinal.repository;

import org.example.backtpfinal.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
