package ua.com.mddorder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.mddorder.dto.RequestEmployeeDto;
import ua.com.mddorder.dto.ResponseEmployeeDto;
import ua.com.mddorder.dto.UserDto;
import ua.com.mddorder.model.Employee;
import ua.com.mddorder.model.User;
import ua.com.mddorder.repository.EmployeeRepository;
import ua.com.mddorder.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
public class EmployeeServiceImpl {

    private final EmployeeRepository employeeRepository;

//    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    @Override
    public List<ResponseEmployeeDto> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<ResponseEmployeeDto> responseEmployeeDtoList = new ArrayList<>();
        for (Employee employee : employees) {
            responseEmployeeDtoList.add(ResponseEmployeeDto
                    .fromEmployeeToResponseEmployeeDto(employee));
        }
        responseEmployeeDtoList.forEach(System.out::println);

        return responseEmployeeDtoList;
    }

//    @Override
    public Employee findByUsername(String username) {
        return null;
    }

//    @Override
    @Transactional
    public Employee findById(Long id) {
        Optional<Employee> optional = employeeRepository.findEmployeeById(id);
        if (optional.isEmpty()) {
            throw new IllegalStateException("Employee with id " + id + " does not exists");
        }
        return employeeRepository.getOne(id);
    }

//    @Override
    public Employee addNewEmployee(Employee employee) {
        Optional<Employee> userOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        return employeeRepository.save(employee);
    }
}
