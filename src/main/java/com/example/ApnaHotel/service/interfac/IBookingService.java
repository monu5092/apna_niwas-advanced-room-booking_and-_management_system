package com.example.ApnaHotel.service.interfac;

import com.example.ApnaHotel.dto.Response;
import com.example.ApnaHotel.entity.Booking;

public interface IBookingService {

    Response  saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBooking();

    Response cancelBooking(Long bookingId);

}
