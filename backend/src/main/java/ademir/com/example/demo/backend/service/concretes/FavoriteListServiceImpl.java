package ademir.com.example.demo.backend.service.concretes;

import org.springframework.stereotype.Service;
import ademir.com.example.demo.backend.model.Product;
import ademir.com.example.demo.backend.model.User;
import ademir.com.example.demo.backend.service.abstracts.FavoriteListService;
import ademir.com.example.demo.backend.service.abstracts.ProductService;
import ademir.com.example.demo.backend.service.abstracts.UserService;

import java.util.List;

@Service
public class FavoriteListServiceImpl implements FavoriteListService {
    private final UserService userService;
    private final ProductService productService;

    public FavoriteListServiceImpl(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void addToFavoriteList(Integer userId, Integer productId) {
        User user = userService.getById(userId);

        Product product = productService.getProductById(productId);

        if (!user.isFavoriteListContainsProduct(product)) {
            user.addToFavoriteList(product);
            userService.save(user);
        }
    }

    @Override
    public List<Product> getProductsByUser(Integer userId) {
        return productService.getFavoritesByUserId(userId);
    }

    @Override
    public void removeFromFavoriteList(Integer userId, Integer productId) {
        productService.removeProductFromFavorites(userId, productId);
    }
}