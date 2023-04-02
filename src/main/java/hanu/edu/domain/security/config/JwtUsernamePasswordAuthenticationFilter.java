package hanu.edu.domain.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import hanu.edu.domain.security.dto.BaseResponseDTO;
import hanu.edu.domain.security.dto.LoginDTO;
import hanu.edu.domain.security.jwt.HelperUtils;
import hanu.edu.domain.security.jwt.JwtConfig;
import hanu.edu.domain.security.jwt.JwtService;
import hanu.edu.domain.user.model.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private final JwtService jwtService;

    private final ObjectMapper objectMapper;

    public JwtUsernamePasswordAuthenticationFilter(AuthenticationManager manager, JwtConfig jwtConfig, JwtService jwtService) {
        super(new AntPathRequestMatcher(jwtConfig.getUrl(), "POST"));
        setAuthenticationManager(manager);
        this.objectMapper = new ObjectMapper();
        this.jwtService = jwtService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        log.info("Start attempt to authentication.");
        LoginDTO loginDTO = objectMapper.readValue(request.getInputStream(), LoginDTO.class);
        log.info("End attempt to authentication.");
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword(), Collections.emptyList()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        String accessToken = jwtService.generateToken(user);
        Map map = new HashMap();
        map.put("accessToken", accessToken);
        map.put("userId", user.getId());
        String json = objectMapper.writeValueAsString(map);
        response.getWriter().write(json);
        response.setContentType("application/json; charset=UTF-8");
        log.info("End success authentication: {}", accessToken);

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        BaseResponseDTO responseDTO = new BaseResponseDTO();
        responseDTO.setCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        responseDTO.setMessage(failed.getLocalizedMessage());
        String json = HelperUtils.JSON_WRITER.writeValueAsString(responseDTO);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write(json);
        return;
    }
}
