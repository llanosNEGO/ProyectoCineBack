package com.devDJ.cinerma.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//Clase S5
@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService jwtUserDetailsService;
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        // Lista de rutas públicas que NO deben pasar por el filtro JWT
        return path.startsWith("/v1/movies/")
                || path.startsWith("/v1/dulceria/")
                || path.startsWith("/v1/cinemas/")
                || path.equals("/login");
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String header = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        if(header != null && header.startsWith("Bearer ")) {
            //Bearer eyJhbGciOiJIU...
            final int TOKEN_POSITION = 7;
            jwtToken = header.substring(TOKEN_POSITION);

            try{
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
            }catch (Exception e) {
                request.setAttribute("msg", e.getMessage());
            }
        }

        if(username != null && jwtToken != null) {
            UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);

            if(jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);
    }
}
