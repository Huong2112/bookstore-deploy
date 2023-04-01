package hanu.edu.domain.security.jwt;

import hanu.edu.domain.user.model.User;
import io.jsonwebtoken.Claims;

import java.security.Key;

public interface JwtService {
    Claims extractClaims(String token);

    Key getKey();

    String generateToken(User user);

    boolean isValidToken(String token);
}
