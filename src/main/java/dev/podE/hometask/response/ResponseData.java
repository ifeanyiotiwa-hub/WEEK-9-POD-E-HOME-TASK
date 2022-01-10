package dev.podE.hometask.response;

import dev.podE.hometask.model.Person;
import dev.podE.hometask.model.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
    private Person person;
    private Subject subject;
}
