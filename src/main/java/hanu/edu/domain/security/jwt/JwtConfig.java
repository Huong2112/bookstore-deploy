package hanu.edu.domain.security.jwt;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class JwtConfig {
    @Value("${jwt.url:/login}")
    private String url;

    @Value("Authorization")
    private String header;

    @Value("${jwt.prefix:Bearer}")
    private String prefix;

    @Value("${jwt.expiration:#{60*60*24}}")
    private int expiration;

    @Value("${jwt.secret:7A24432646294A404E635266556A586E327234753778214125442A472D4B6150}")
    private String secret;
}
