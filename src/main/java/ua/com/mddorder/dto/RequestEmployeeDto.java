package ua.com.mddorder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.com.mddorder.model.Employee;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RequestEmployeeDto {

    private String username;
    private String email;
    private String password;

    public static RequestEmployeeDto fromEmployeeToDto(Employee employee) {

        RequestEmployeeDto requestEmployeeDto = new RequestEmployeeDto();
        requestEmployeeDto.setUsername(employee.getUsername());
        requestEmployeeDto.setEmail(employee.getEmail());
        requestEmployeeDto.setPassword(employee.getPassword());
        return requestEmployeeDto;
    }
}
