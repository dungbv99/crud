package hello.shoppingwithspring.web.controller;

import hello.shoppingwithspring.constraints.FieldMatch;
import hello.shoppingwithspring.model.product.Product;
import hello.shoppingwithspring.model.product.Product_User;
import  hello.shoppingwithspring.repository.user.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    private  Integer a;

    public String upload(MultipartFile imageFile) {
        // Upload file to storage
        String fileName = new String();
        try {
            byte[] bytes = imageFile.getBytes();
            fileName = imageFile.getOriginalFilename();
            System.out.println("fileName                " + fileName);
            File file = new File("src/main/resources/static/upload");
            //File file1 = new File("target/classes/static/upload");
            String path = file.getPath();
            //String path1 = file1.getPath();
            String fileLocation = path+ "/" + fileName;
            //String fileLocation1 = path1 + "/" + fileName;
            System.out.println("fileLocation                     " + fileLocation);
            FileOutputStream fos = new FileOutputStream(fileLocation);
            //FileOutputStream fos1 = new FileOutputStream(fileLocation1);
            fos.write(bytes);
            fos.close();
            //fos1.write(bytes);
            //fos1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Update image name in DB
        imageFile.getOriginalFilename();
        return fileName;

    }




    @GetMapping("/addproduct")
    public String addProduct(Model model){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        Product product = new Product();
        model.addAttribute("product",product);
        return "dung/addproduct";
    }

    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute("product") Product product,Model model ,  @RequestParam("image") MultipartFile imageFile){
        System.out.println(product.getDescribeProduct());
        System.out.println(product.getPriceProduct());
        System.out.println(product.getImagePath());
        System.out.println("image          " + imageFile );
        System.out.println("upload            "+upload(imageFile));
        product.setImagePath(upload(imageFile));

        if(product.getNumberProduct()==null)
        {
            product.setNumberProduct(0);
        }

        productRepository.save(product);
        return "dung/home";
    }
    @GetMapping("/edit")
    public String edit(Model model){
            List<Product> list = productRepository.findAll();
            model.addAttribute("list",list);
            return "dung/editproduct";
    }

    @GetMapping("/{id}")
    public String editdetail (Model model,@PathVariable("id") Integer id){
        Product product_user =new Product();
        model.addAttribute("id",id);
        a=id;
        model.addAttribute("product",product_user);
        System.out.println("iddddddddddddddddd" + id);
        return "dung/editdetail";
    }
    @PostMapping("/editsuccess")
    public  String editsuccess(@ModelAttribute("product") Product product,@RequestParam("image") MultipartFile imageFile){
        product.setId(a);
        product.setImagePath(upload(imageFile));
        productRepository.save(product);
        return "dung/home";
    }


}
