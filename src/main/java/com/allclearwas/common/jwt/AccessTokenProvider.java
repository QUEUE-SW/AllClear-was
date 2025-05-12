package com.allclearwas.common.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.allclearwas.common.exception.jwt.TokenErrorCode;
import com.allclearwas.common.exception.jwt.TokenException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccessTokenProvider {

	private final SecretKey key;
	private final long accessExpireTime;

	public AccessTokenProvider(@Value("${jwt.token.access.secret-key}") String secretKey,
		@Value("${jwt.token.access.expire-time}") long accessExpireTime) {
		this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
		this.accessExpireTime = accessExpireTime;
	}


	public String generateToken(Long studentId, String identifier) {
		Date date = new Date();
		return Jwts.builder()
			.claims(createClaims(studentId, identifier))
			.signWith(key)
			.expiration(createExpiredDate(date, accessExpireTime))
			.compact();
	}


	public Map<String, Object> createClaims(Long studentId, String identifier) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", studentId);
		claims.put("identifier", identifier);
		return claims;
	}

	public String resolveToken(String header) {
		if (StringUtils.hasText(header) && header.startsWith("Bearer ")) {
			return header.substring(7);
		}
		return header;
	}


	public Claims getClaims(String token) throws TokenException {
		try {
			return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
		} catch (ExpiredJwtException e) {
			log.warn("만료된 토큰 = {}", e.getMessage());
			throw new TokenException(TokenErrorCode.TOKEN_IS_EXPIRED);
		} catch (MalformedJwtException e) {
			log.warn("유효하지 않은 토큰 형식 = {}", e.getMessage());
			throw new TokenException(TokenErrorCode.TOKEN_IS_MALFORMED);
		} catch (SignatureException e) {
			log.warn("조작된 토큰 = {}", e.getMessage());
			throw new TokenException(TokenErrorCode.TOKEN_IS_TEMPERED);
		}
	}

	public Date createExpiredDate(Date date, Long expirationTime) {
		return new Date(date.getTime() + expirationTime);
	}
}
