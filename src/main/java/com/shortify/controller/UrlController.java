package com.shortify.controller;

import com.shortify.dto.UrlRequest;
import com.shortify.dto.UrlResponse;
import com.shortify.service.UrlService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService = urlService;
    }

    @PostMapping("/api/shorten")
    public ResponseEntity<UrlResponse> shortenUrl(@Valid @RequestBody UrlRequest request) {
        return ResponseEntity.ok(urlService.shortenUrl(request));
    }

    @GetMapping("/s/{code}")
    public RedirectView redirectToOriginal(@PathVariable String code) {
        String originalUrl = urlService.getOriginalUrl(code);
        return new RedirectView(originalUrl);
    }
}
