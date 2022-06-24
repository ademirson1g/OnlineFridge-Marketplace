package ademir.com.example.demo.backend.service.abstracts;

import org.springframework.http.ResponseEntity;
import ademir.com.example.demo.backend.model.Product;
import ademir.com.example.demo.backend.payload.request.AddProductRequest;
import java.util.List;

public interface ProductService {
    List<Product> findAll();

    List<Product> findAll(int pageNo, int pageSize);

    List<Product> findAll(int pageNo, int pageSize, String queryWord);

    Product getProductById(Integer id);

    List<Product> getAllByPageWithoutBlackList(int pageNo, int pageSize);

    List<Product> getAllByPageWithoutBlackList(int pageNo, int pageSize, String queryWord);

    List<Product> getFavoritesByUserId(Integer userId);

    void removeProductFromFavorites(Integer userId, Integer productId);

    ResponseEntity<?> addProduct(AddProductRequest addProductRequest);

    ResponseEntity<?> removeProduct(Integer productId);
}
