package ua.com.mddorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.mddorder.dto.ResponseEmployeeDto;
import ua.com.mddorder.model.Employee;
import ua.com.mddorder.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employee/")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("all")
    public ResponseEntity<List<ResponseEmployeeDto>> getAllEmployees() {
        List<ResponseEmployeeDto> employeesDto = employeeService.getAll();
        if (employeesDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeesDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ResponseEmployeeDto> getEmployeeById(@PathVariable(name = "id") Long id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ResponseEmployeeDto response = ResponseEmployeeDto.fromEmployeeToResponseEmployeeDto(employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
