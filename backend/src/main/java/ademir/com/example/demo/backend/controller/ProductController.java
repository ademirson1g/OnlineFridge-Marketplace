package ademir.com.example.demo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ademir.com.example.demo.backend.model.Product;
import ademir.com.example.demo.backend.payload.request.AddProductRequest;
import ademir.com.example.demo.backend.service.abstracts.ProductService;
import ademir.com.example.demo.backend.service.concretes.Log;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get-all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Product> findAll() {
        Log.getInstance(ProductController.class).info("Products succesfully fetched from user.");
        Log.getInstance(ProductController.class).error("Products not succesfully fetched from user.");
        return productService.findAll();
    }

    @GetMapping("/get-all-by-page")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Product> findAll(@RequestParam("page-no") int pageNo,@RequestParam("page-size") int pageSize) {
        Log.getInstance(ProductController.class).info("Products succesfully fetched.");
        Log.getInstance(ProductController.class).error("Products not succesfully fetched.");
        return productService.findAll(pageNo, pageSize);
    }
    
    @GetMapping("/get-all-by-page-contains")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Product> findAll(@RequestParam("page-no") int pageNo,
                                 @RequestParam("page-size") int pageSize,
                                 @RequestParam("query-word") String queryWord) {                              
        return productService.findAll(pageNo, pageSize, queryWord);
    }

    @GetMapping("/get-all-by-page-without-blacklist")
    @PreAuthorize("hasRole('USER')")
    public List<Product> getAllByPageWithoutBlackList(@RequestParam("page-no") int pageNo, @RequestParam("page-size") int pageSize) {
        Log.getInstance(ProductController.class).info("Products succesfully fetched from user.");
        Log.getInstance(ProductController.class).error("Products not succesfully fetched from user.");
        return productService.getAllByPageWithoutBlackList(pageNo,pageSize);
    }

    @GetMapping("/get-all-by-page-without-blacklist-contains")
    @PreAuthorize("hasRole('USER')")
    public List<Product> getAllByPageWithoutBlackList(@RequestParam("page-no") int pageNo,
                                                      @RequestParam("page-size") int pageSize,
                                                      @RequestParam("query-word") String queryWord) {
        return productService.getAllByPageWithoutBlackList(pageNo,pageSize,queryWord);
    }
    

    @GetMapping("/get")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Product getProductById(@RequestParam("id") Integer id) {
        return productService.getProductById(id);
    }
    
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addProduct(@RequestBody AddProductRequest addProductRequest) {
        return productService.addProduct(addProductRequest);
    }

    @GetMapping("/remove")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> removeProduct(@RequestParam("id") Integer productId) {
        return productService.removeProduct(productId);
    }
}
