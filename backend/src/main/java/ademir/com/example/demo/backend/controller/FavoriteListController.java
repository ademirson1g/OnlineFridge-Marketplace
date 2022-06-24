package ademir.com.example.demo.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ademir.com.example.demo.backend.model.Product;
import ademir.com.example.demo.backend.security.UserDetailsImpl;
import ademir.com.example.demo.backend.service.abstracts.FavoriteListService;
import ademir.com.example.demo.backend.payload.response.MessageResponse;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/favorite-list")
public class FavoriteListController {
    private FavoriteListService favoriteListService;

    public FavoriteListController(FavoriteListService favoriteListService) {
        this.favoriteListService = favoriteListService;
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('USER')")
    ResponseEntity<?> addToFavoriteList(@RequestParam("id") Integer productId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        favoriteListService.addToFavoriteList(userDetails.getId(), productId);

        return ResponseEntity.ok(new MessageResponse("Product added to favorites"));
    }

    @GetMapping("/get-favorites")
    @PreAuthorize("hasRole('USER')")
    List<Product> getFavoriteList() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return favoriteListService.getProductsByUser(userDetails.getId());
    }

    @GetMapping("/remove")
    @PreAuthorize("hasRole('USER')")
    ResponseEntity<?> removeFromFavoriteList(@RequestParam("id") Integer productId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        favoriteListService.removeFromFavoriteList(userDetails.getId(), productId);

        return ResponseEntity.ok(new MessageResponse("Product removed from favorites"));
    }
}