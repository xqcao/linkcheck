package com.linkcheckweb.demo.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linkcheckweb.demo.model.LinkObj;
import com.linkcheckweb.demo.model.OneRegion;
import com.linkcheckweb.demo.services.HealthService;

@Controller
public class MyController {
	
	@Autowired
    private HealthService healthService;
	
	@GetMapping("/")
	public String hello() {
		return "hello";
	}
	@GetMapping("/ping")
	@ResponseBody
	public String pingpong() {
		return "pong";
	}
	@GetMapping("/linkstatus")
    public String linkStatus(Model model) {
        Map<String, Boolean> linkStatuses = new HashMap<>();
        List<String> links = new ArrayList<String>();
        links.add("https://www.google.com");
        links.add("https://www.example.com");
        links.add("http://127.0.0.1:8888");
        for (String link : links) {
            try {
                URL linkUrl = new URL(link);
                HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
                connection.setRequestMethod("HEAD");
                int responseCode = connection.getResponseCode();
                connection.disconnect();

                boolean isReachable = (responseCode == HttpURLConnection.HTTP_OK);
                linkStatuses.put(link, isReachable);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                linkStatuses.put(link, false);
            }
        }

        model.addAttribute("linkStatuses", linkStatuses);
        return "linkstatus"; 
    }
	@GetMapping("/linkstatusobj")
    public String linkStatusObj(Model model) {
        Map<String, Boolean> linkStatuses = new HashMap<>();
        List<OneRegion> links = new ArrayList<OneRegion>();
        
        links.add(new OneRegion("GOOGLE","https://www.google.com",false,false));
        links.add(new OneRegion("APPLE","https://www.apple.com",false,false));
        links.add(new OneRegion("example","https://www.example.com",false,false));
        links.add(new OneRegion("LOCAL","http://127.0.0.1:8888",false,false));
        links.add(new OneRegion("details","http://localhost:8080/actuator/health",false,false));
        
        for (OneRegion link : links) {
            try {
                URL linkUrl = new URL(link.getHostname());
                HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
                connection.setRequestMethod("HEAD");
                int responseCode = connection.getResponseCode();
                connection.disconnect();

                boolean isReachable = (responseCode == HttpURLConnection.HTTP_OK);
                link.setPolicyStatus(isReachable);
            } catch (IOException e) {
                System.out.println(e.getMessage());
//                linkStatuses.put(link, false);
            }
        }
       

        model.addAttribute("links", links);
 
        return "linkstatusobj"; 
    }
	
	@GetMapping("/linkdetails")
    public String linkDetails(Model model) {
		 List<LinkObj> links = new ArrayList<LinkObj>();
		 links.add(new LinkObj("GOOGLE","https://www.google.com",false,false));
        links.add(new LinkObj("local1","http://localhost:8080/actuator/health",false,false));
        links.add(new LinkObj("local2","http://localhost:8080/actuator/health",false,false));
        Map<String, Object> oooMap =null;
        for (LinkObj lk : links) {
        	oooMap = healthService.getHealthInfo(lk.getHostname());
        	if(oooMap !=null && oooMap.size()>0) {
        		lk.setPolicyStatus(true);
        		lk.setLinkDetails(oooMap);
        	}
        	
        	System.out.println("checking ---> "+ lk.getHostname());
        }
        System.out.println(links.toString());
        model.addAttribute("details", links);
        return "details"; 
    }
}
