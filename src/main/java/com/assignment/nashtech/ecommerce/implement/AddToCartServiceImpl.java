package com.assignment.nashtech.ecommerce.implement;

import com.assignment.nashtech.ecommerce.dto.AddToCartDTO;
import com.assignment.nashtech.ecommerce.model.AddToCart;
import com.assignment.nashtech.ecommerce.model.Product;
import com.assignment.nashtech.ecommerce.model.User;
import com.assignment.nashtech.ecommerce.repository.AddToCartRepository;
import com.assignment.nashtech.ecommerce.repository.ProductRepository;
import com.assignment.nashtech.ecommerce.repository.UserRepository;
import com.assignment.nashtech.ecommerce.service.AddToCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddToCartServiceImpl implements AddToCartService {
    @Autowired
    private AddToCartRepository addToCartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<AddToCart> getAllAddToCart() {
        return addToCartRepository.findAll();
    }

    @Override
    public Optional<AddToCart> getAddToCartById(int addToCartId) {
        return addToCartRepository.findById(addToCartId);
    }

    @Override
    public AddToCart saveAddToCart(AddToCartDTO addToCartDTO) {
        User user = userRepository.findById(addToCartDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not Found"));
        Product product = productRepository.findById(addToCartDTO.getProductId()).orElseThrow(() -> new RuntimeException("Product not Found"));

        AddToCart addToCart = new AddToCart();
        addToCart.setUser(user);
        addToCart.setProduct(product);
        addToCart.setQuantity(addToCartDTO.getQuantity());
        return addToCartRepository.save(addToCart);
    }

    @Override
    public AddToCart updateAddToCartById(int addToCartId, AddToCartDTO addToCartDTO){
        User user = userRepository.findById(addToCartDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not Found"));
        Product product = productRepository.findById(addToCartDTO.getProductId()).orElseThrow(() -> new RuntimeException("Product not Found"));
        Optional<AddToCart> addToCartExisting = addToCartRepository.findById(addToCartId);

        if (addToCartExisting.isPresent()){
            AddToCart addToCart = new AddToCart();
            addToCart.setUser(user);
            addToCart.setProduct(product);
            addToCart.setQuantity(addToCartDTO.getQuantity());
            return addToCartRepository.save(addToCart);
        }

        return null;
    }

    @Override
    public void deleteAddToCartById(int addToCartId){
        addToCartRepository.deleteById(addToCartId);
    }
}
