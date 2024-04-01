package com.africa.semicolon.URLshortnerservice.data.respositories;

import com.africa.semicolon.URLshortnerservice.data.model.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends JpaRepository<UrlEntity, String> {

    @Query(value= "SELECT originalUrl from UrlEntity where shortenedUrl =?1", nativeQuery = true)
    UrlEntity findByShortenedUrl(String shortenedUrl);
}
