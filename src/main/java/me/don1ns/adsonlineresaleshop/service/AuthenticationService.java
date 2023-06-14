package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.DTO.RegisterReqDTO;

public interface AuthenticationService {
    boolean login(String userName, String password);

    boolean register(RegisterReqDTO registerReqDTO);
}
