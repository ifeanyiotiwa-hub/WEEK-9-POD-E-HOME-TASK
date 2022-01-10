package dev.podE.hometask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
// Odochi Okara
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String nationality;
    private Date birthDate;
    private String key;


}
