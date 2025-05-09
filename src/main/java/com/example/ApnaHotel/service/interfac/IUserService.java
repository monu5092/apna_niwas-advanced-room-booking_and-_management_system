package com.example.ApnaHotel.service.interfac;

import com.example.ApnaHotel.dto.LoginRequest;
import com.example.ApnaHotel.dto.Response;
import com.example.ApnaHotel.entity.User;


public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);


}
