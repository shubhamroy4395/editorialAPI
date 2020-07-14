package com.example.test.demo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.demo.dao.NewsDao;
import com.example.test.demo.model.HelloBean;
import com.example.test.demo.model.News;

@RestController
public class Controller {
	@Autowired
	private NewsDao newsDao;
	
	@GetMapping(path = "/hindu")
	public Map<String, List<News>> getAllNews() throws IOException {
		return newsDao.getAllNews();
	}
	
	@GetMapping("/hello")
	public HelloBean hello() {
		return new HelloBean("title","article","The Hindu","14 july 2020");
	}

}
