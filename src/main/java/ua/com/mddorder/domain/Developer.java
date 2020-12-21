package ua.com.mddorder.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Developer {
    private Long id;
    private String name;
    private String surname;


}
