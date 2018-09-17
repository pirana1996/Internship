package com.example.urlshortener;

import com.example.urlshortener.exceptions.IllegalUrlFormat;
import com.example.urlshortener.model.Url;
import com.example.urlshortener.repository.UrlRepository;
import com.example.urlshortener.service.UrlService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
public class UrlShortenerApplicationTests {

//	@InjectMocks
	UrlService urlService;

//	@Mock
	UrlRepository urlRepository;


	@Before
	public void setUp() {
		urlRepository = mock(UrlRepository.class);
		urlService = new UrlService(urlRepository);
	}

	@Test
	public void create_url_for_existing_url() {
		String originalUrl = "https://www.gmail.com";
		String shortUrl = "aaa123";
		Url actual = null;
		boolean exceptionOccurred = false;

		when(urlRepository.findByOriginalUrl(any(String.class)))
				.thenReturn(new Url(shortUrl, originalUrl));

		try {
			actual = urlService.createUrl(originalUrl);
		} catch (IllegalUrlFormat e) {
			exceptionOccurred = true;
		}
		assertNotNull(actual);
		assertFalse(exceptionOccurred);
		assertEquals(shortUrl, actual.getShortUrl());
		assertEquals(originalUrl, actual.getOriginalUrl());
	}

	@Test
	public void create_url_for_non_existing_url() throws IllegalUrlFormat {
		String originalUrl = "https://www.gmail.com";
		String shortUrl = "aaa123";
		Url actual = null;
		boolean exceptionOccurred = false;

		when(urlRepository.findByOriginalUrl(any(String.class))).thenReturn(null);
		when(urlRepository.save(any(Url.class))).thenReturn(new Url(shortUrl, originalUrl));

		try {
			actual = urlService.createUrl(originalUrl);
		}catch (IllegalUrlFormat e) {
			exceptionOccurred = true;
		}

		assertNotNull(actual);
		assertFalse(exceptionOccurred);
		assertEquals(shortUrl, actual.getShortUrl());
		assertEquals(originalUrl, actual.getOriginalUrl());
	}

	@Test
	public void create_url_with_invalid_format() {
		String originalUrl = "google.com";
		boolean exceptionOccurred = false;
		try {
			urlService.createUrl(originalUrl);
		} catch (IllegalUrlFormat illegalUrlFormat) {
			exceptionOccurred = true;
		}
		assertTrue(exceptionOccurred);
	}


	@Test
	public void fetch_url_with_non_existing_url() {
		String shortUrl = "x1a4";
		boolean exceptionOccurred = false;
		when(urlRepository.findByShortUrl(any(String.class))).thenReturn(null);

		try {
			urlService.fetchUrl(shortUrl);
		} catch (Exception illegalUrlFormat) {
			exceptionOccurred = true;
		}
		assertTrue(exceptionOccurred);
	}

	@Test
	public void fetch_url_with_existing_url() {
		String shortUrl = "aK94";
		String originalUrl = "https://www.gmail.com";
		Url url = null;
		boolean exceptionOccurred = false;

		when(urlRepository.findByShortUrl(any(String.class))).thenReturn(new Url(shortUrl, originalUrl));

		try {
			url = urlService.fetchUrl(shortUrl);
		} catch (Exception e) {
			exceptionOccurred = true;
		}

		assertFalse(exceptionOccurred);
		assertEquals(shortUrl, url.getShortUrl());
	}

	@Test
	public void test_positive_url_path() {
		String url = "https://www.gmail.com";
		boolean validUrl = urlService.checkValidation(url);
		assertTrue(validUrl);
	}

	@Test
	public void test_negative_url_path() {
		String url = "pdosgk";
		boolean validUrl = urlService.checkValidation(url);
		assertFalse(validUrl);
	}
}
