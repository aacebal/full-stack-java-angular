package com.adelacebal.fullstackappangularspringboot.rest;

import com.adelacebal.fullstackappangularspringboot.convertor.RoomEntityToReservationResponseConverter;
import com.adelacebal.fullstackappangularspringboot.entity.RoomEntity;
import com.adelacebal.fullstackappangularspringboot.model.request.ReservationRequest;
import com.adelacebal.fullstackappangularspringboot.model.response.ReservationResponse;
import com.adelacebal.fullstackappangularspringboot.repository.PageableRoomRepository;
import com.adelacebal.fullstackappangularspringboot.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {

	@Autowired
	PageableRoomRepository pageableRoomRepository;

	@Autowired
	RoomRepository roomRepository;

	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<ReservationResponse> getAvailableRooms(
			@RequestParam(value = "checkin")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkin, 
			@RequestParam(value = "checkout")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkout, Pageable pageable) {

		Page<RoomEntity> roomEntityList = pageableRoomRepository.findAll(pageable);
		
		return roomEntityList.map(new RoomEntityToReservationResponseConverter());
	}

	@RequestMapping(path = "/{roomId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RoomEntity> getRoomById(
	        @PathVariable
            Long roomId) {

	    RoomEntity roomEntity = roomRepository.findById(roomId);

	    return new ResponseEntity<>(roomEntity, HttpStatus.OK);
    }
	
	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	
	public ResponseEntity<ReservationResponse> createReservation(
			@RequestBody
			ReservationRequest reservationRequest) { 
		
		return new ResponseEntity<>(new ReservationResponse(), HttpStatus.CREATED);
	}

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

	public ResponseEntity<ReservationResponse> updateReservation(
			@RequestBody
					ReservationRequest reservationRequest) {

		return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReservation(
			@PathVariable
			long reservationId) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
