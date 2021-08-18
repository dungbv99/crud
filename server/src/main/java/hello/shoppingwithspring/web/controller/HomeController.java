package hello.shoppingwithspring.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import hello.shoppingwithspring.constraints.FieldMatch;
import hello.shoppingwithspring.model.product.Product;
import hello.shoppingwithspring.model.product.Product_User;
import  hello.shoppingwithspring.repository.user.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String homepage(){
        return "index";
    }
}
