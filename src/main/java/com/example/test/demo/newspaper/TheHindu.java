package com.example.test.demo.newspaper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.example.test.demo.model.News;


public class TheHindu {
	public List<News> /*List<String>/*Map<String, String>*/ getHinduArticles() throws IOException{
		List<News> newsObj = new ArrayList<>();
		Map<String, String> hinduArticlesMap = new HashMap<String, String>();
		Map<String, String> urlMap = getUrlFromRss();
	    String firstURL = urlMap.get(NewsAppConstants.FIRST_RSS_URL);    
	    hinduArticlesMap.put(NewsAppConstants.FIRST_RSS_PUBLISH_DATE, urlMap.get(NewsAppConstants.FIRST_RSS_PUBLISH_DATE));
		hinduArticlesMap.putAll(getEditorial(firstURL,NewsAppConstants.FIRST_ARTICLE_TITLE,NewsAppConstants.FIRST_ARTICLE_BODY));
	    News firstNewsObj = new News("The Hindu",hinduArticlesMap.get(NewsAppConstants.FIRST_ARTICLE_TITLE),hinduArticlesMap.get(NewsAppConstants.FIRST_ARTICLE_BODY),hinduArticlesMap.get(NewsAppConstants.FIRST_RSS_PUBLISH_DATE));
	    newsObj.add(firstNewsObj);
	    
	    
		String secondUrl = urlMap.get(NewsAppConstants.SECOND_RSS_URL);          
		 hinduArticlesMap.put(NewsAppConstants.SECOND_RSS_PUBLISH_DATE, urlMap.get(NewsAppConstants.SECOND_RSS_PUBLISH_DATE));
		hinduArticlesMap.putAll(getEditorial(secondUrl,NewsAppConstants.SECOND_ARTICLE_TITLE,NewsAppConstants.SECOND_ARTICLE_BODY));
		News secNewsObj = new News("The Hindu",hinduArticlesMap.get(NewsAppConstants.SECOND_ARTICLE_TITLE),hinduArticlesMap.get(NewsAppConstants.SECOND_ARTICLE_BODY),hinduArticlesMap.get(NewsAppConstants.SECOND_RSS_PUBLISH_DATE));
		newsObj.add(secNewsObj);
		return newsObj;
	}
	
	
	//puts title and article body in a map
	private static Map<String, String> getEditorial(String link, String title, String content){
		Map<String, String> firstEditorialMap = new HashMap<String, String>();
		  Document firstEditorialLinkDoc = null;
		  String article = "";
		try {
			firstEditorialLinkDoc = getDocument(link);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(firstEditorialLinkDoc!=null) {
	        firstEditorialMap.put(title, firstEditorialLinkDoc.title());
	        Elements editlinks = firstEditorialLinkDoc.select(NewsAppConstants.HINDU_CONTENT_BODY_CSS_SELECTOR);
	        article =editlinks.select("p").text();
	        firstEditorialMap.put(content,article);
		}
	        return firstEditorialMap;
	}
	
	
	
	//puts title and article body in a map
	private static List<String> getEditorialList(String link){
		List<String> artList = new ArrayList<String>();
		Map<String, String> firstEditorialMap = new HashMap<String, String>();
		  Document firstEditorialLinkDoc = null;
		  String article = "";
		try {
			firstEditorialLinkDoc = getDocument(link);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(firstEditorialLinkDoc!=null) {
	       // firstEditorialMap.put(title, firstEditorialLinkDoc.title());
			artList.add(firstEditorialLinkDoc.title());
	        Elements editlinks = firstEditorialLinkDoc.select(NewsAppConstants.HINDU_CONTENT_BODY_CSS_SELECTOR);
	        article =editlinks.select("p").text();
	        artList.add(article);
	       // firstEditorialMap.put(content,article);
		}
	        return artList;
	}
	
	
	
	
	
	
	
	public static Map<String, String> getUrlFromRss() throws IOException {
		
		Map<String, String> hinduUrlMap =  new HashMap<String, String>();
		Document docRss = getDocument(NewsAppConstants.HINDU_RSS_URL);
		String myJXml = docRss.toString();
		JSONObject jObject = XML.toJSONObject(myJXml);
		JSONArray hinduJsonArray = jObject.getJSONObject("rss").getJSONObject("channel").getJSONArray("item");
//		for(int i=0; i<hinduJsonArray.length(); i++) {
//			JSONObject jobj = hinduJsonArray.getJSONObject(i);
//			
//		}
		
		
		JSONObject firstObject = hinduJsonArray.getJSONObject(0);
		JSONObject secondObject = hinduJsonArray.getJSONObject(1);
		
		hinduUrlMap.put(NewsAppConstants.FIRST_RSS_URL, firstObject.getString(NewsAppConstants.LINK));
		hinduUrlMap.put(NewsAppConstants.FIRST_RSS_PUBLISH_DATE,firstObject.getString(NewsAppConstants.PUB_DATE));
		
		hinduUrlMap.put(NewsAppConstants.SECOND_RSS_URL, secondObject.getString(NewsAppConstants.LINK));
		hinduUrlMap.put(NewsAppConstants.SECOND_RSS_PUBLISH_DATE,secondObject.getString(NewsAppConstants.PUB_DATE));
		
		return hinduUrlMap;	
	}
	
	public static Document getDocument(String url) throws IOException {
		return Jsoup.connect(url)
	    	     .userAgent(NewsAppConstants.JSOUP_USER_AGENT)
	    	     .get();
	}

}

