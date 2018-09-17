package com.example.urlshortener.exceptions;

public class NonExistingShortUrl extends Exception {
    public NonExistingShortUrl() {
        super("NonExistingShortUrl exception occurred!");
    }
}
