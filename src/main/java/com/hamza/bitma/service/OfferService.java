package com.hamza.bitma.service;

import com.hamza.bitma.dto.mapper.MapString;
import com.hamza.bitma.dto.mapperInterface.IMapperDto;
import com.hamza.bitma.dto.model.OfferDto;
import com.hamza.bitma.entity.Offer;
import com.hamza.bitma.repository.OfferRepository;
import com.hamza.bitma.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class OfferService {


    private final OfferRepository offerRepository;
    private final IMapperDto<Offer, OfferDto> offerMapper;
    private final MapString<Map<String,String>,Offer> mapString;
    private final OfferImageService offerImageService;
    public List<OfferDto> getAllOffers() {
        log.info("getAllOffers");
        return offerMapper.convertListToListDto(offerRepository.findAll(), OfferDto.class);
    }

    public ResponseEntity<String> createOffer(Map<String,String> offerDto, MultipartFile[] files) {


        createDirIfNotExist();
        List<String> fileNames = new ArrayList<>();

        Arrays.stream(files).forEach(file -> {
            byte[] bytes;
            try {
                bytes = file.getBytes();
                String extension = FileUtil.getExtension(Objects.requireNonNull(file.getOriginalFilename()));
                String fileName = UUID.randomUUID() + extension;
                Files.write(Paths.get(FileUtil.folderPath + fileName), bytes);
                fileNames.add(fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Offer offer = mapString.convertToEntity(offerDto, Offer.class);
        Offer offerSaved = offerRepository.save(offer);
        offerImageService.saveOfferImages(offerSaved.getId(), fileNames);
        return ResponseEntity.status(HttpStatus.CREATED).body("Offer created successfully");
    }

    private void createDirIfNotExist() {
        //create directory to save the files
        File directory = new File(FileUtil.folderPath);
        if (! directory.exists()){
            directory.mkdir();
        }
    }
}
