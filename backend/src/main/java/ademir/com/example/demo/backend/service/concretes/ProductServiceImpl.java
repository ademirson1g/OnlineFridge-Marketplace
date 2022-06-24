package ademir.com.example.demo.backend.service.concretes;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ademir.com.example.demo.backend.model.Product;
import ademir.com.example.demo.backend.payload.request.AddProductRequest;
import ademir.com.example.demo.backend.repository.ProductRepository;
import ademir.com.example.demo.backend.security.UserDetailsImpl;
import ademir.com.example.demo.backend.service.abstracts.ProductService;
import ademir.com.example.demo.backend.service.abstracts.UserService;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserService userService;

    public ProductServiceImpl(ProductRepository productRepository,
                              UserService userService) {
        this.productRepository = productRepository;
        this.userService = userService;
       
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);

        return productRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Product> findAll(int pageNo, int pageSize, String queryWord) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);

        return productRepository.findAllByNameContains(queryWord,pageable).getContent();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: Product is not found."));
    }

    @Override
    public List<Product> getAllByPageWithoutBlackList(int pageNo, int pageSize) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        Pageable pageable = PageRequest.of(pageNo-1, pageSize);

        List<Product> productsWithoutBlackList = productRepository.getProductsWithoutBlackList(userDetails.getId(), pageable);

        return productsWithoutBlackList;
    }

    @Override
    public List<Product> getAllByPageWithoutBlackList(int pageNo, int pageSize, String queryWord) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        Pageable pageable = PageRequest.of(pageNo-1, pageSize);

        List<Product> productsWithoutBlackList = productRepository.getProductsWithoutBlackList(userDetails.getId(), queryWord, pageable);

        return productsWithoutBlackList;
    }

    @Override
    public List<Product> getFavoritesByUserId(Integer userId) {
        return productRepository.getFavoritesByUserId(userId);
    }

    @Override
    public void removeProductFromFavorites(Integer userId, Integer productId) {
        productRepository.removeProductFromFavorites(userId, productId);
    }

    @Override
    public ResponseEntity<?> addProduct(AddProductRequest addProductRequest) {
      
        Product product = new Product(addProductRequest.getProductName());

        productRepository.save(product);

        return ResponseEntity.ok("Product added to system!");
    }

    @Override
    public ResponseEntity<?> removeProduct(Integer productId) {
        productRepository.deleteById(productId);

        return ResponseEntity.ok("Product removed from system!");
    }
}
