package ademir.com.example.demo.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ademir.com.example.demo.backend.model.CustomList;

@Repository
public interface CustomListRepository extends JpaRepository<CustomList, Integer> {

}