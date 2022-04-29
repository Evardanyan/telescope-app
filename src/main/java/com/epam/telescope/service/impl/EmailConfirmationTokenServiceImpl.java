package com.epam.telescope.service.impl;

import com.epam.telescope.exception.TokenNotFoundException;
import com.epam.telescope.model.EmailConfirmationToken;
import com.epam.telescope.model.Profile;
import com.epam.telescope.repository.EmailConfirmationTokenRepository;
import com.epam.telescope.repository.ProfileRepository;
import com.epam.telescope.service.EmailConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailConfirmationTokenServiceImpl implements EmailConfirmationTokenService {

    private final EmailConfirmationTokenRepository emailConfirmationTokenRepository;
    private final ProfileRepository profileRepository;

    @Value("${email.confirmation.token.expiration.time.minutes}")
    private long expirationTime;

    @Override
    public void saveEmailConfirmationToken(EmailConfirmationToken token) {
        emailConfirmationTokenRepository.save(token);
    }

    @Override
    public void setConfirmedAt(String token) {
        emailConfirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }

    @Override
    public EmailConfirmationToken generateToken(Profile user) {
        return new EmailConfirmationToken(
                UUID.randomUUID().toString(),
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(expirationTime),
                user
        );
    }

    @Override
    public void confirmToken(String token) {
        EmailConfirmationToken confirmationToken = validateToken(token);
        setConfirmedAt(token);
        enableProfile(confirmationToken.getProfile().getEmail());
    }

    private EmailConfirmationToken validateToken(String token) {
        EmailConfirmationToken confirmationToken = emailConfirmationTokenRepository
                .findByToken(token)
                .orElseThrow(() -> new TokenNotFoundException("Token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("Email already confirmed");
        }

        LocalDateTime expiresAt = confirmationToken.getExpiresAt();
        if (expiresAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Token already expired");
        }
        return confirmationToken;
    }

    private void enableProfile(String email) {
        profileRepository.enableProfile(email);
    }
}