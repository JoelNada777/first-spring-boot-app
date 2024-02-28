package com.first.myfirstapp.service;

import com.first.myfirstapp.models.DTO.LoginDTO;

public interface AuthService {
    String login(LoginDTO loginDTO);
}
