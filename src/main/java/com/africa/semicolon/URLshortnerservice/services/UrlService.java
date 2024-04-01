package com.africa.semicolon.URLshortnerservice.services;

import com.africa.semicolon.URLshortnerservice.data.model.UrlEntity;
import com.africa.semicolon.URLshortnerservice.dtos.UrlRequest;

public interface UrlService {

    public String getOriginalUrl (String id);


    UrlEntity generateShortUrl(String url);

//    public UrlEntity generateShortLink (UrlRequest urlRequest);
}
