package com.hamza.bitma.controller;

import com.hamza.bitma.dto.model.OfferDto;
import com.hamza.bitma.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/offer")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping("/all")
    public List<OfferDto> getAllOffers() {
        return offerService.getAllOffers();
    }

    @PostMapping
    public ResponseEntity<String> createOffer(@RequestParam("images") MultipartFile[] files, @RequestParam Map<String, String> offerDto) {
        return offerService.createOffer(offerDto, files);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<OfferDto>> getByUserId(@PathVariable Long id) {
        return offerService.getByUserId(id);
    }

}
