package blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import blog.com.models.entity.Account;
import blog.com.models.entity.Blogs;
import blog.com.services.BlogsService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogsEditController {

	@Autowired
	private BlogsService blogsService;
	@Autowired
	private HttpSession session;
	@GetMapping("/blog/edit/{blogId}")
	public String getBlogEditPage(@PathVariable Long blogId, Model model) {
		Account account = (Account) session.getAttribute("loginAccountInfo");
		if (account == null) {
			return "redirect:/account/login";
		} else {
			Blogs blogs  = blogsService.blogEditCheck(blogId);
			if(blogs == null) {
				return "redirect:/blog/list";
			}else {
				model.addAttribute("accountName",account.getAccountName());
				model.addAttribute("blogs", blogs);
					return "blog_edit.html";
			}
	}
	}

}
