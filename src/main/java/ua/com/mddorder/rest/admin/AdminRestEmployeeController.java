package ua.com.mddorder.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.mddorder.model.Employee;
import ua.com.mddorder.service.AdminService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/admin/employee")
public class AdminRestEmployeeController {

    private final AdminService adminService;

    @Autowired
    public AdminRestEmployeeController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/all")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employees = adminService.getAll();
        if (employees == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {

        Employee saveEmployee = (Employee) adminService.add(employee);
        if (saveEmployee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id") Long id) {
        Employee employee = adminService.getOne(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
