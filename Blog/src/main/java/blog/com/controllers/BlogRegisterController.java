package blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import blog.com.models.entity.Account;
import blog.com.services.BlogsService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogRegisterController {

	@Autowired
	private BlogsService blogsService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/blog/register")
	public  String getBlogRegisterPage(Model model) {
		Account account = (Account) session.getAttribute("loginAccountInfo");
		if(account == null) {
			return "redirect:/account/login";
		}else {
			model.addAttribute("accountName",account.getAccountName());
			return "blog_register.html";
		}
	}
}
