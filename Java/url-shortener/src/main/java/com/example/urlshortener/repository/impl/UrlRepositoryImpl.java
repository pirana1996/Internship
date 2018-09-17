package com.example.urlshortener.repository.impl;

import com.example.urlshortener.model.Url;
import com.example.urlshortener.repository.UrlRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepositoryImpl extends UrlRepository, JpaRepository<Url, String> {
}
