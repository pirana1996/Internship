package com.example.urlshortener.api;

import com.example.urlshortener.exceptions.IllegalUrlFormat;
import com.example.urlshortener.exceptions.NonExistingShortUrl;
import com.example.urlshortener.model.Url;
import com.example.urlshortener.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UrlController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UrlService.class);
    private UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> fetchUrl(@PathVariable String shortUrl, HttpServletResponse response) {
        LOGGER.info("Passing short url parameter!");
        try {
            Url url = urlService.fetchUrl(shortUrl);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(new URI(url.getOriginalUrl()));
            return new ResponseEntity(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
        } catch (IllegalUrlFormat|NonExistingShortUrl|URISyntaxException e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/new/**")
    public ResponseEntity createUrl(HttpServletRequest request) {
        LOGGER.info("Passing short url parameter!");
        String originalUrl = request.getRequestURL().substring(30);
        String queryString = Optional
                .ofNullable(request.getQueryString())
                .map(s -> "?".concat(s))
                .orElse("");
        originalUrl += queryString;

        LOGGER.info("Qurey url: " + originalUrl);
        try {
            Url url = urlService.createUrl(originalUrl);
            return new ResponseEntity<Url>(url, HttpStatus.OK);
        } catch (IllegalUrlFormat illegalUrlFormat) {
            illegalUrlFormat.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
