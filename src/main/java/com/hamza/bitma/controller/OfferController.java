package com.hamza.bitma.controller;

import com.hamza.bitma.dto.model.OfferDto;
import com.hamza.bitma.service.OfferService;
import com.hamza.bitma.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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

}
