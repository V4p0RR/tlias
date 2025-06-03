package com.wen.tlias;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@SpringBootTest
class TliasApplicationTests {

	@SuppressWarnings("deprecation")
	@Test
	// TODO 测试jwt令牌生成
	public void testJwt() {
		String jwt = Jwts.builder()
				.signWith(SignatureAlgorithm.HS256,
						"IAmV1rtualYourDadIsComingAndShutTheFuckUpCykaBlyatCaoNiMaShaBiCaoNiMa")
				.claim("name", "wen")
				.claim("age", 20)
				.setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
				.compact();
		System.out.println(jwt);
	}

	@Test
	// TODO 测试jwt令牌解析
	@SuppressWarnings("deprecation")
	public void testJwtOut() {
		Claims claims = Jwts.parser()
				.setSigningKey("IAmV1rtualYourDadIsComingAndShutTheFuckUpCykaBlyatCaoNiMaShaBiCaoNiMa")
				.parseClaimsJws(
						"eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoid2VuIiwiYWdlIjoyMCwiZXhwIjoxNzQ4NTg4MjMwfQ.P5Q2SbBxaLXI67q5lFp0_vwXWY0hyarbFLWNYDRZdwY")
				.getBody();
		System.out.println(claims);
	}
}
