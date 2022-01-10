package dev.podE.hometask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    private String key;
    private String name;
    private String subject_type;
    private  int work_count;
    private Object[] works;
}
