package blog.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.com.models.dao.BlogsDao;
import blog.com.models.entity.Blogs;

@Service
public class BlogsService {

	@Autowired
	private BlogsDao blogsDao;
	
	public List<Blogs>selectAllBlogList(Long accountId) {
	if (accountId == null) {
		return null;
	} else {
		return blogsDao.findAll();
		
	}
}

	
	public boolean createBlog(String blogTitle,
			String categoryName,
			String blogImage,
			String article,
			Long accountId) {
		if(blogsDao.findByBlogTitle(blogTitle)==null) {
			blogsDao.save(new Blogs(blogTitle,categoryName,blogImage,article,accountId));
				return true;
			}else {
				return false;
			}
	}	
		
}

