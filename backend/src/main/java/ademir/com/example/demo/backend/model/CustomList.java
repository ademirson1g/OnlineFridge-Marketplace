package ademir.com.example.demo.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CustomList {
    @Id
    @GeneratedValue
    private int id;

    private String Name;
    private String Email;
    private String Password;

}