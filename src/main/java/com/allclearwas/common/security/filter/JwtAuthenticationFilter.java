package com.allclearwas.common.security.filter;


import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import com.allclearwas.common.exception.BaseErrorCode;
import com.allclearwas.common.exception.GlobalException;
import com.allclearwas.common.exception.jwt.TokenErrorCode;
import com.allclearwas.common.exception.jwt.TokenException;
import com.allclearwas.common.jwt.AccessTokenProvider;
import com.allclearwas.domains.session.service.SessionService;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final AccessTokenProvider accessTokenProvider;
	private final UserDetailsService userDetailsService;
	private final SessionService sessionService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {
		log.info("-----------------JWT FILTER-----------------");

		String headerAtk = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (headerAtk == null) {
			log.info("-------Anonymous Request-------");
			filterChain.doFilter(request, response);
			return;
		}

		String token = accessTokenProvider.resolveToken(headerAtk);
		log.info("token: {}", token);

		String id = getClaims(token);

		sessionService.save(Long.valueOf(id));
		log.info("session save: {}", id);

		UserDetails userDetails = getUserDetails(id);

		authenticate(userDetails);


		filterChain.doFilter(request, response);
	}

	private String getClaims(String token) throws ServletException {
		Claims claims = null;
		try {
			claims = accessTokenProvider.getClaims(token);
		} catch (TokenException e) {
			handleJwtException(e.getBaseErrorCode());
		}
		return String.valueOf(claims.get("id", Long.class));
	}

	private UserDetails getUserDetails(String studentId) throws ServletException {
		UserDetails userDetails = null;
		try {
			userDetails = userDetailsService.loadUserByUsername(studentId);
		} catch (UsernameNotFoundException e) {
			log.error("UsernameNotFoundException = {}", e.getMessage());
			sessionService.remove(Long.valueOf(studentId));
			handleJwtException(TokenErrorCode.INVALID_TOKEN);
		}
		return userDetails;
	}

	private void authenticate(UserDetails userDetails) {
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
			userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private void handleJwtException(BaseErrorCode baseErrorCode) throws ServletException {
		log.warn("JwtAuthException = {}, {}", baseErrorCode.errorCausedBy().getErrorCode(),
			baseErrorCode.getErrorMessage());
		GlobalException exception = new GlobalException(baseErrorCode);
		throw new ServletException(exception);
	}
}
