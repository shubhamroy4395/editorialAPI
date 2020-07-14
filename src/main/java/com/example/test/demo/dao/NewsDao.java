package com.example.test.demo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.test.demo.model.News;
import com.example.test.demo.newspaper.TheHindu;

@Component
public class NewsDao {


	private List<News> newsList = new ArrayList<>();
	Map<String, List<News>> apiMap = new LinkedHashMap<>();

	public Map<String, List<News>> /*List<News>*/ getAllNews() throws IOException{
		TheHindu hindu = new TheHindu();
		apiMap.put("editorials", hindu.getHinduArticles());
		//return hindu.getHinduArticles();
		return apiMap;
		
	}
}
