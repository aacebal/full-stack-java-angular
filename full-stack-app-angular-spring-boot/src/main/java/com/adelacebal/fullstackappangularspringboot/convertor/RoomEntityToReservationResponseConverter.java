package com.adelacebal.fullstackappangularspringboot.convertor;

import com.adelacebal.fullstackappangularspringboot.entity.RoomEntity;
import com.adelacebal.fullstackappangularspringboot.model.response.Links;
import com.adelacebal.fullstackappangularspringboot.model.response.ReservationResponse;
import com.adelacebal.fullstackappangularspringboot.model.response.Self;
import com.adelacebal.fullstackappangularspringboot.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;

public class RoomEntityToReservationResponseConverter implements Converter<RoomEntity, ReservationResponse>{

    @Override
    public ReservationResponse convert(RoomEntity source) {

        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setRoomNumber(source.getRoomNumber());
        reservationResponse.setPrice(Integer.valueOf(source.getPrice()));

        Links links = new Links();
        Self self = new Self();
        self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
        links.setSelf(self);

        reservationResponse.setLink(links);

        return reservationResponse;
    }
}
