package com.epam.telescope.service;

public interface EmailSenderService {

    void send(String to, String email);

    String buildEmail(String name, String link);
}