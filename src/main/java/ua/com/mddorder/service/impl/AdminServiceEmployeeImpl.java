package ua.com.mddorder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.mddorder.model.Employee;
import ua.com.mddorder.repository.EmployeeRepository;
import ua.com.mddorder.service.AdminService;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceEmployeeImpl implements AdminService<Employee> {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public AdminServiceEmployeeImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee add(Employee entity) {
        return employeeRepository.save(entity);
    }

    @Override
    public Employee getOne(Long id) {
        Optional<Employee> optional = employeeRepository.findEmployeeById(id);
        if (optional.isEmpty()) {
            throw new IllegalStateException("Employee with id " + id + " does not exists");
        }
        return employeeRepository.getOne(id);
    }
}
