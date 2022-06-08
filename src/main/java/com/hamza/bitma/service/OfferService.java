package com.hamza.bitma.service;

import com.hamza.bitma.dto.mapper.MapString;
import com.hamza.bitma.dto.mapperInterface.IMapperDto;
import com.hamza.bitma.dto.model.OfferDto;
import com.hamza.bitma.entity.Offer;
import com.hamza.bitma.entity.User;
import com.hamza.bitma.enumeration.RoomType;
import com.hamza.bitma.repository.OfferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class OfferService {


    private final OfferRepository offerRepository;
    private final UserService userService;
    private final IMapperDto<Offer, OfferDto> offerMapper;
    private final MapString<Map<String,String>,Offer> mapString;
    private final OfferImageService offerImageService;


    public List<OfferDto> getAllOffers() {
        log.info("getAllOffers");
        return offerMapper.convertListToListDto(offerRepository.findAll(), OfferDto.class);
    }

    public ResponseEntity<String> createOffer(Map<String,String> offerDto, MultipartFile[] files) {
        Offer offer = mapString.convertToEntity(offerDto, Offer.class);

        User user = userService.findById(Long.parseLong(offerDto.get("user")));

        if( user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
        }
        offer.setUser(user);
        Offer offerSaved = offerRepository.save(offer);
        offerImageService.saveOfferImages(offerSaved.getId(), files);
        return ResponseEntity.status(HttpStatus.CREATED).body("Offer created successfully");
    }

    public ResponseEntity<List<OfferDto>> getByUserId(Long id) {
        List<Offer> offers = offerRepository.findAllByUserId(id);
        if(offers.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(offerMapper.convertListToListDto(offers,OfferDto.class));
    }

    public ResponseEntity<OfferDto> getOfferById(Long id) {
        Offer offer = offerRepository.findById(id).orElse(null);
        if(offer == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(offerMapper.convertToDto(offer,OfferDto.class));
        }
    }

    public ResponseEntity<String> deleteOffer(Long id) {
        Offer offer = offerRepository.findById(id).orElse(null);
        if(offer == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Offer not found");
        } else {
            offerRepository.delete(offer);
            return ResponseEntity.status(HttpStatus.OK).body("Offer deleted successfully");
        }
    }

    public ResponseEntity<String> updateOffer(Long id, OfferDto offerDto) {
        Offer offer = offerRepository.findById(id).orElse(null);
        if(offer == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Offer not found");
        } else {
            offer.setTitle(offerDto.getTitle());
            offer.setDescription(offerDto.getDescription());
            offer.setCity(offerDto.getCity());
            offer.setAddress(offerDto.getAddress());
            offer.setPrice(offerDto.getPrice());
            offer.setPlaces(offerDto.getPlaces());
            offer.setRooms(offerDto.getRooms());
            offer.setRoomType(RoomType.valueOf(offerDto.getRoomType()));
            offer.setAvailability(offerDto.getAvailability());
            offer.setAvailableFrom(offerDto.getAvailableFrom());

            offerRepository.save(offer);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Offer updated successfully");
    }
}
