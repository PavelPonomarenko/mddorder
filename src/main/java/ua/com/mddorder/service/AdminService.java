package ua.com.mddorder.service;

import ua.com.mddorder.dto.ResponseEmployeeDto;
import ua.com.mddorder.model.Employee;

import java.util.List;

public interface AdminService<T> {

    List<T> getAll();

    T add(T entity);

    Employee getOne(Long id);
}
