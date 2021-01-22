package ua.com.mddorder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.com.mddorder.model.Employee;
import ua.com.mddorder.model.User;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmployeeDto {

    private Long id;
    private String username;
    private String email;

    public static ResponseEmployeeDto fromEmployeeToResponseEmployeeDto(Employee employee) {

        ResponseEmployeeDto responseEmployeeDto = new ResponseEmployeeDto();
        responseEmployeeDto.setId(employee.getId());
        responseEmployeeDto.setUsername(employee.getUsername());
        responseEmployeeDto.setEmail(employee.getEmail());
        return responseEmployeeDto;
    }
}
