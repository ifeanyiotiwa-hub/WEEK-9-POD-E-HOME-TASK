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


    public Person(int id, String firstName, String lastName, String email, String password,String nationality, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.nationality = nationality;
        this.birthDate = birthDate;
    }
}
