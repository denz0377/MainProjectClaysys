package com.shoppingcart.shoppingcartproject.Controllerx;

import com.shoppingcart.shoppingcartproject.Modelx.Product;
import com.shoppingcart.shoppingcartproject.Modelx.User;
import com.shoppingcart.shoppingcartproject.Servicex.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ProductController {
    @Autowired
    public ProductServiceImpl productServiceImpl;


    @GetMapping("/productAdd")
    public String showRegistrationForm(Model model) {
        model.addAttribute("product", new Product());

        return "product_form";

    }

    @PostMapping("/productSave")
    public String processRegister(@ModelAttribute("product")  Product product) {
        productServiceImpl.saveProduct(product);
        return "redirect:/productList";
    }


    @GetMapping("/productList")
    public String listUsers(Model model) {
        List<Product> listProduct = productServiceImpl.getAllProduct();
        model.addAttribute("listProduct", listProduct);

        return "product";
    }

    @GetMapping("/showUpadteFormProduct/{id}")
    public String showUpadteForm(@PathVariable(value = "id") int id, Model model) {
        Product product = productServiceImpl.getProductById(id);
        model.addAttribute("product", product);
        return "update_product";
    }


    @GetMapping("/deleteProduct/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) {


        this.productServiceImpl.deleteProductById(id);
        return "redirect:/productList";
    }


}
