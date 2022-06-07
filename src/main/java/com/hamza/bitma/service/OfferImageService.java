package com.hamza.bitma.service;

import com.hamza.bitma.entity.OfferImage;
import com.hamza.bitma.repository.OfferImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferImageService {

    private final OfferImageRepository offerImageRepository;

    public List<String> getAllOfferImages(Long offerId) {
        return offerImageRepository.findAllByOfferId(offerId).stream()
                .map(OfferImage::getImageUrl)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public void saveOfferImages(Long offerId, List<String> images) {

        images.forEach(image -> {
            OfferImage offerImage = new OfferImage();
            offerImage.setOfferId(offerId);
            offerImage.setImage(image);
            offerImageRepository.save(offerImage);
        });
    }

    public ResponseEntity<byte[]> getImage(String image) {
        try {
            return ResponseEntity.ok(Files.readAllBytes(Paths.get("uploads/" + image)));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
