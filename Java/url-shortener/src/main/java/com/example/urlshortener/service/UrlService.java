package com.example.urlshortener.service;

import com.example.urlshortener.exceptions.IllegalUrlFormat;
import com.example.urlshortener.exceptions.NonExistingShortUrl;
import com.example.urlshortener.model.Url;
import com.example.urlshortener.repository.UrlRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UrlService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UrlService.class);
    private final UrlRepository urlRepository;


    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Url createUrl(String queryUrl) throws IllegalUrlFormat {
        LOGGER.info("Creating url...");
        boolean valid = checkValidation(queryUrl);
        if (!valid)
            throw new IllegalUrlFormat();

        return Optional.ofNullable(urlRepository.findByOriginalUrl(queryUrl))
                .orElseGet(() -> {
                    String shortLink = RandomStringUtils.random(4, ALPHABET);
                    Url newUrl = new Url(shortLink, queryUrl);
                    return urlRepository.save(newUrl);
                });
    }

    @Transactional
    public Url fetchUrl(String queryUrl) throws IllegalUrlFormat, NonExistingShortUrl {
        LOGGER.info("Fetching url...");
        return Optional.ofNullable(urlRepository.findByShortUrl(queryUrl))
                .map(url -> url.incrementRating())
                .orElseThrow(() -> new NonExistingShortUrl());
    }

    public boolean checkValidation(String queryUrl) {
        UrlValidator urlValidator = new UrlValidator();
        boolean valid = urlValidator.isValid(queryUrl);
        LOGGER.info("Valid: " + valid);
        return valid;
    }
}
