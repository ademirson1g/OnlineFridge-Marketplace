package ademir.com.example.demo.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ademir.com.example.demo.backend.model.CustomList;
import ademir.com.example.demo.backend.repository.CustomListRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class CustomListController {

    @Autowired
    private CustomListRepository custom;

    @GetMapping("/")
    public List<CustomList> GetUser() {
        return custom.findAll();
    }

    @GetMapping("/{id}")  
    public CustomList GetUser(@PathVariable Integer id) {
        return custom.findById(id).orElse(null);
    }

    @PostMapping("/")
    public CustomList PostUser(@RequestBody CustomList customList) {
        return custom.save(customList);
    }

    @PutMapping("/")
    public CustomList PutUser(@RequestBody CustomList customList) {
        CustomList oldCustomList = custom.findById(customList.getId()).orElse(null);
        oldCustomList.setName(customList.getName());
        oldCustomList.setEmail(customList.getEmail());
        oldCustomList.setPassword(customList.getPassword());
        return custom.save(oldCustomList);
    }

    @DeleteMapping("/{id}") 
    public Integer DeleteUser(@PathVariable Integer id ) {
        custom.deleteById(id);
        return id;
    }

}
  