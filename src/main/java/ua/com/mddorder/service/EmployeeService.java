package ua.com.mddorder.service;

import ua.com.mddorder.dto.ResponseEmployeeDto;
import ua.com.mddorder.model.Employee;

import java.util.List;

public interface EmployeeService {

    List getAll();

    Employee getOne(Long id);

    Employee findByUsername(String username);


    Employee add(Employee employee);


}
