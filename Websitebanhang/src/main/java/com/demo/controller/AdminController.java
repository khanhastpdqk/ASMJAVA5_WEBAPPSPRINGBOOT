package com.demo.controller;

import com.demo.model.Account;
import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.repo.AccountRepo;
import com.demo.repo.CategoryRepo;
import com.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {
    //  Category
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    ProductRepo productRepo;

    @RequestMapping("/admin/category")
    public String listcategory(Model model) {
        Category item = new Category();
        model.addAttribute("item", item);
        List<Category> items = categoryRepo.findAll();
        model.addAttribute("items", items);
        return "admin/category/list";

    }

    @RequestMapping("/admin/category/create")
    public String createcategory(Model model, @Valid @ModelAttribute("item") Category item, BindingResult result) {
//        accountRepo.save(item);
        if (result.hasErrors() || item.getName().equals("")) {
            List<Category> items = categoryRepo.findAll();
            model.addAttribute("items", items);
            if(item.getName().equals("")) {
                model.addAttribute("mess", "Không để trống tên!");
            }
            return "admin/category/list";


        } else {
//            if(item.getPhoto()!=null && !item.getPhoto().isEmpty()){
//                File file = new File("C:\\Users\\Admin\\IdeaProjects\\assignment2\\src\\main\\resources\\static\\images"+item.getPhoto().getBytes());
//                System.out.println(file.getAbsolutePath());
//                item.getPhoto().equals(file);
//            }
            categoryRepo.save(item);
            return "redirect:/admin/category";

        }

    }

    @RequestMapping("/admin/category/edit/{id}")
    public String editcategory(Model model, @PathVariable("id") String id) {
        Category item = categoryRepo.findById(id).get();


        model.addAttribute("item", item);
        List<Category> items = categoryRepo.findAll();
        model.addAttribute("items", items);
        return "admin/category/list";
    }

    @RequestMapping("/admin/category/delete/{id}")
    public String deletecategory(@PathVariable("id") String id) {
        categoryRepo.deleteById(id);
        return "redirect:/admin/category";
    }

    @RequestMapping("/admin/category/update")
    public String updatecategory(Model model, @Valid @ModelAttribute("item") Category item, BindingResult result) {
//        accountRepo.save(item);
        if (result.hasErrors()) {
            List<Category> items = categoryRepo.findAll();
            model.addAttribute("items", items);
            return "admin/category/list";

        } else {
            categoryRepo.save(item);
            return "redirect:/admin/category/edit/" + item.getId();

        }

    }

    //  Product
    @RequestMapping("/admin/product")
    public String listproduct(Model model) {
        Product item = new Product();
        model.addAttribute("item", item);
        model.addAttribute("categoryList", categoryRepo.findAll());
        List<Product> items = productRepo.findAll();
        model.addAttribute("items", items);
        return "admin/product/list";

    }

    @RequestMapping("/admin/product/create")
    public String createproduct(Model model, @Valid @ModelAttribute("item") Product item,
                                BindingResult result) {
//        accountRepo.save(item);
        if (result.hasErrors()) {
            model.addAttribute("categoryList", categoryRepo.findAll());
            List<Product> items = productRepo.findAll();
            model.addAttribute("items", items);
            return "admin/product/list";

        } else {
            productRepo.save(item);
            return "redirect:/admin/product";

        }


    }

    @RequestMapping("/admin/product/edit/{id}")
    public String editproduct(Model model, @PathVariable("id") int id) {
        Product item = productRepo.findById(id).get();
        model.addAttribute("categoryList", categoryRepo.findAll());

        model.addAttribute("item", item);
        List<Product> items = productRepo.findAll();
        model.addAttribute("items", items);
        return "admin/product/list";
    }

    @RequestMapping("/admin/product/delete/{id}")
    public String deleteproduct(@PathVariable("id") int id) {
        productRepo.deleteById(id);
        return "redirect:/admin/product";
    }

    @RequestMapping("/admin/product/update")
    public String updateproduct(Model model,
                                @Valid @ModelAttribute("item") Product item, BindingResult result) {
//        accountRepo.save(item);
        if (result.hasErrors()) {
            model.addAttribute("categoryList", categoryRepo.findAll());
            List<Product> items = productRepo.findAll();
            model.addAttribute("items", items);
            return "admin/product/list";

        } else {
            productRepo.save(item);
            return "redirect:/admin/product/edit/" + item.getId();

        }

    }


    //  Account
    @RequestMapping("/admin/account")
    public String listAcc(Model model) {
        Account item = new Account();
        model.addAttribute("item", item);
        List<Account> items = accountRepo.findAll();
        model.addAttribute("items", items);
        System.out.println(items);
        return "admin/account/list";

    }

    @RequestMapping("/admin/account/create")
    public String createaccount(Model model,@Valid @ModelAttribute("item") Account item, BindingResult result) {
//        accountRepo.save(item);
        if (result.hasErrors()) {
            List<Account> items = accountRepo.findAll();
            model.addAttribute("items", items);
            return "admin/account/list";

        } else {

            accountRepo.save(item);
            return "redirect:/admin/account";

        }

    }

    @RequestMapping("/admin/account/edit/{username}")
    public String editaccount(Model model, @PathVariable("username") String username) {
        Account item = accountRepo.findById(username).get();
        model.addAttribute("item", item);
        List<Account> items = accountRepo.findAll();
        model.addAttribute("items", items);
        return "admin/account/list";
    }

    @RequestMapping("/admin/account/delete/{username}")
    public String deleteaccount(@PathVariable("username") String username) {
        accountRepo.deleteById(username);
        return "redirect:/admin/account";
    }

    @RequestMapping("/admin/account/update")
    public String updateaccount(Model model,@Valid @ModelAttribute("item") Account item, BindingResult result) {
//        accountRepo.save(item);
        if (result.hasErrors()) {
            List<Account> items = accountRepo.findAll();
            model.addAttribute("items", items);
            return "admin/account/list";

        } else {
            accountRepo.save(item);
            return "redirect:/admin/account/edit/" + item.getUsername();

        }

    }
}
