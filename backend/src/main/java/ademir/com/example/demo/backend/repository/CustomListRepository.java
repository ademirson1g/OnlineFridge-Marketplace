package ademir.com.example.demo.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import ademir.com.example.demo.backend.model.CustomList;

public interface CustomListRepository extends JpaRepository<CustomList, Long> {
  List<CustomList> findByPublished(boolean published);
  List<CustomList> findByTitleContaining(String title);
}