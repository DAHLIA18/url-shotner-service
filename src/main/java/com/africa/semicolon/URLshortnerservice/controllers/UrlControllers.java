package com.africa.semicolon.URLshortnerservice.controllers;

import com.africa.semicolon.URLshortnerservice.data.model.UrlEntity;
import com.africa.semicolon.URLshortnerservice.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UrlControllers {

    @Autowired
    private UrlService urlService;
    @GetMapping("/{id}")
    public String getOriginalUrl(@PathVariable String id){
        return  urlService.getOriginalUrl(id);

    }
    @PostMapping("/shortner")
    public UrlEntity generateShortUrl(@RequestBody String url){
        return urlService.generateShortUrl(url);
    }
}
