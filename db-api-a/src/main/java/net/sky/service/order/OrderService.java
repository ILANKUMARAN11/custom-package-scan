package net.sky.service.order;


import net.sky.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired(required = false)
    ProductService productService;
}
