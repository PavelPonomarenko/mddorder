package ua.com.mddorder.service;

import ua.com.mddorder.dto.ResponseEmployeeDto;
import ua.com.mddorder.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<ResponseEmployeeDto> getAll();

    Employee findByUsername(String username);

    Employee findById(Long id);

    Employee addNewEmployee(Employee employee);

}
