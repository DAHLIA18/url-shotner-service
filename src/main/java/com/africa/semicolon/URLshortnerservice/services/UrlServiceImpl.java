package com.africa.semicolon.URLshortnerservice.services;

import com.africa.semicolon.URLshortnerservice.data.model.UrlEntity;
import com.africa.semicolon.URLshortnerservice.data.respositories.UrlRepository;
import com.africa.semicolon.URLshortnerservice.dtos.UrlRequest;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlRepository urlRepository;


    @Override
    public String getOriginalUrl(String id) {
        urlRepository.findByShortenedUrl(id);
        return null;
    }

    @Override
    public UrlEntity generateShortUrl(String url) {
        if(! isUrlValid(url)){
            System.out.println("URL is not valid");
            return null;
        }
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setOriginalUrl(url);
        urlEntity.setShortenedUrl(getRandomChars());

        return urlRepository.save(urlEntity);
    }

    private String getRandomChars() {
        String randomStr = "";
        String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 5; i++) {
            randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
        }
        return randomStr;
    }
        private static boolean isUrlValid(String url){
        return UrlValidator.getInstance().isValid(url);
    }
}
