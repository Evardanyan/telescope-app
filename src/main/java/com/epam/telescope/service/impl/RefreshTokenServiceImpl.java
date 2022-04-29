package com.epam.telescope.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.epam.telescope.config.JwtConfigurationProperties;
import com.epam.telescope.exception.AccessDeniedException;
import com.epam.telescope.model.Profile;
import com.epam.telescope.model.enums.Role;
import com.epam.telescope.service.ProfileService;
import com.epam.telescope.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.epam.telescope.model.enums.Role.ADMIN;
import static com.epam.telescope.model.enums.Role.USER;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RequiredArgsConstructor
@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final ProfileService profileService;
    private final JwtConfigurationProperties configurationProperties;

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new AccessDeniedException("Refresh token is missing");
        }
        String refreshToken = authorizationHeader.substring("Bearer ".length());
        Algorithm algorithm = Algorithm.HMAC256(configurationProperties.getSecret().getBytes());
        String tokenIssuer = request.getRequestURL().toString();
        String accessToken = generateNewToken(refreshToken, tokenIssuer, algorithm);
        response.setHeader("access_token", accessToken);
        response.setHeader("refresh_token", refreshToken);
    }

    private String generateNewToken(String refreshToken, String issuer, Algorithm algorithm) {
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(refreshToken);
        String email = decodedJWT.getSubject();
        Profile user = profileService.getProfileByEmail(email);
        Role role = user.isAdmin() ? ADMIN : USER;
        return JWT.create()
                .withSubject(user.getEmail())
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis()
                        + configurationProperties.getExpirationTime() * 60 * 1000))
                .withIssuer(issuer)
                .withClaim("roles", List.of(role.name()))
                .sign(algorithm);
    }
}