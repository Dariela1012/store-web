package com.example.store_web.service;

import org.springframework.stereotype.Service;

@Service
public class ContactoService {

    public String enviarMensaje() {
        return "Mensaje enviado desde ContactoService (versión 1)";
    }
}

