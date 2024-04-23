package org.example.backtpfinal.repository;

import org.example.backtpfinal.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Override
    Optional<Address> findById(Long aLong);
}
