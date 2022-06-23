package ademir.com.example.demo.backend.service.abstracts;

import ademir.com.example.demo.backend.model.Product;

import java.util.List;

public interface FavoriteListService {
    void addToFavoriteList(Integer userId, Integer productId);

    List<Product> getProductsByUser(Integer userId);

    void removeFromFavoriteList(Integer userId, Integer productId);
}
