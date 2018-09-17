package com.example.urlshortener.repository;

import com.example.urlshortener.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UrlRepository {

    Url findByOriginalUrl(String orginalUrl);
    Url findByShortUrl(String shortUrl);
    Url save(Url entity);
}
