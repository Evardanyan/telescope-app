package com.epam.telescope.service;

import com.epam.telescope.model.EmailConfirmationToken;
import com.epam.telescope.model.Profile;

public interface EmailConfirmationTokenService {

    void saveEmailConfirmationToken(EmailConfirmationToken token);

    void setConfirmedAt(String token);

    EmailConfirmationToken generateToken(Profile user);

    void confirmToken(String token);
}
