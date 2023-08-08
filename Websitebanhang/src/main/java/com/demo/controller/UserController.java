package com.demo.controller;

import com.demo.model.*;
import com.demo.repo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
	@Autowired
	HttpSession session;
	@Autowired
	CartRepo cartRepo;
	@Autowired
	CartDetailRepo cartDetailRepo;




	@Data @AllArgsConstructor
	public static class PriceRange{
		int id;
		int minValue;
		int maxValue;
		String display;
	}

	List<PriceRange> priceRangeList = Arrays.asList(
		new PriceRange(0,0, Integer.MAX_VALUE, "Tất cả"),
		new PriceRange(1,0, 10000000, "Dưới 10 triệu"),
		new PriceRange(2,10000000, 20000000, "Từ 10-20 triệu"),
		new PriceRange(3,20000000, Integer.MAX_VALUE, "Trên 20 triệu")
	);

	@RequestMapping("/")
	public String index(
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="") String categoryId,
			@RequestParam(defaultValue="0") int priceRangeId,
			@RequestParam(defaultValue="0") int p,
			Model model) {

		if(session.getAttribute("username") == null){
			return  "redirect:/login";
		}
		model.addAttribute("priceRangeList", priceRangeList);
		model.addAttribute("categoryList", categoryRepo.findAll());
		model.addAttribute("productList", productRepo.findAll());

		int minPrice = priceRangeList.get(priceRangeId).minValue;
		int maxPrice = priceRangeList.get(priceRangeId).maxValue;
		// phan quyen admin
		Account user =  accountRepo.findById(session.getAttribute("username").toString()).get();
		model.addAttribute("user",user);


		Pageable pageable = PageRequest.of(p,6);
//        Page<Product> page = repo.findByKeywords("%"+keywords+"%",pageable);
		model.addAttribute("page", productRepo.findAll());
		// TODO: Search & paginate
		if(!categoryId.isEmpty()){
			//co cate id
			Page<Product> page1 = productRepo.searchAllByCategoryNamePrice(categoryId,"%"+keyword+"%",minPrice,maxPrice,pageable);
			model.addAttribute("page",page1);
		}else {
			// khong cate id
			Page<Product> page2 = productRepo.searchByNamePrice("%"+keyword+"%", minPrice,maxPrice,pageable);
			model.addAttribute("page",page2);

		}

		return "home/index";
	}
	@Autowired
	ProductRepo productRepo;
	@Autowired
	CategoryRepo categoryRepo;
	@GetMapping("/detail/{id}")
	public String viewProduct(@PathVariable int id, Model model) {
		Product product = productRepo.findById(id).orElse(null);
		model.addAttribute("product", product);
		return "home/detail";
	}

	@RequestMapping("/add-to-cart/{id}")
	public String addToCart(@PathVariable int id,Model model){
		Product product = productRepo.findById(id).get();
		//tim ra sp
		CartDetail cartDetail = new CartDetail();
		// tao ra 1 gio hang trong
		cartDetail.setProduct(product);
		cartDetail.setPrice(product.getPrice());
		cartDetail.setQuantity(1);
		// set data cho gio hang
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			Cart cart1 = new Cart();
			List<CartDetail> listcart = new ArrayList<>();
			listcart.add(cartDetail);
			cart1.setCartDetails(listcart);
			session.setAttribute("cart",cart1);
			System.out.println(cart1.getCartDetails().size());
			System.out.println("chay duoc den day la 1 nua r");

		}
		else {
			Boolean check = false;
			List<CartDetail> list = cart.getCartDetails();


			for(CartDetail x:list){
				if(x.getProduct().getId() == id){
					check = true;
					x.setQuantity(x.getQuantity()+1);
				}
			}

			if(check == false) {
				list.add(cartDetail);

			}
			cart.setCartDetails(list);
			session.setAttribute("cart",cart);
			System.out.println("chay lan 2 den day la ok");

		}
		return "redirect:/cart";
	}

	@RequestMapping("/remove-cart/{id}")
	public String removeCart(@PathVariable Integer id) {
		Product product = productRepo.findById(id).get();
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart==null){
			return "redirect:/cart";
		}else {
			List<CartDetail> list = cart.getCartDetails();
			List<CartDetail> list1 = new ArrayList<>();
			for (CartDetail x : list) {
				if (x.getProduct().getId() != id) {
					list1.add(x);
				}
			}
			cart.setCartDetails(list1);
			session.setAttribute("cart", cart);
			System.out.println("xoa thanh cong");
			return "redirect:/cart";
		}
	}


	@GetMapping("/cart")
	public String cart(Model model){
			Cart cart = (Cart) session.getAttribute("cart");
			if(cart == null){
				session.setAttribute("message1","Bạn chưa có đồ trong giỏ hàng!");
				return "redirect:/";
			}else {
				List<CartDetail> list = cart.getCartDetails();
				int tong = list.stream().map(o -> o.getPrice() * o.getQuantity()).reduce(0, (o1, o2) -> o1 + o2);
				model.addAttribute("tong", tong);
				session.removeAttribute("message1");
				return "home/cart";
			}

	}
	@GetMapping("/confirm")
	public String confirm(Model model){
		Cart cart = (Cart) session.getAttribute("cart");
		List<CartDetail> list = cart.getCartDetails();
		int tong = list.stream().map(o->o.getPrice()*o.getQuantity()).reduce(0,(o1,o2)->o1+o2);
		model.addAttribute("tong",tong);
		return "home/confirm";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		return "home/about";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}
	@Autowired
	AccountRepo accountRepo;
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
		// TODO: Check if user/password exists in database

		Account account = accountRepo.findByUsernameAndPassword(username, password);
			if (account!= null) {
				session.setAttribute("username", username);
				Boolean checkrole = account.isAdmin();
				session.setAttribute("checkrole",checkrole);
				System.out.println(username);
				return "redirect:/";

			}else {
				model.addAttribute("message", "Tên đăng nhập/mật khẩu không đúng");
				return "login";
			}


	}

	@PostMapping("/purchase")
	public String purchase(@RequestParam String address,Model model){
		System.out.println("address=" + address);
		// TODO: Save items to database
		Cart cart = (Cart) session.getAttribute("cart");
		cartRepo.save(cart);
		session.removeAttribute("cart");
		session.setAttribute("message1","Bạn đã mua hàng đến " + address+"!");
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(){
		session.removeAttribute("username");
		session.removeAttribute("cart");
		return "redirect:/login";
	}
	//tim kiem

}

