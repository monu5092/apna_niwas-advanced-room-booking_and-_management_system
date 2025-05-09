package com.example.ApnaHotel.repo;

import com.example.ApnaHotel.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {


    Optional<Booking> findByBookingConfirmationCode(String confirmationCode);
}
