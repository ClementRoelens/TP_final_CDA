package org.example.backtpfinal.service;

import org.example.backtpfinal.entities.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBaseService<T> {
    public T save(T element);
    public List<T> getAll();
    public T getById(Long id);
    public  T update(T element);
    public void deleteById (Long id);


}
