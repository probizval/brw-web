package com.brw.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@CrossOrigin(origins = "*")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Value("${auth0.audience}")
	private String audience;

	@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
	private String issuer;
	
	private static StringBuffer protectedUserUris = new StringBuffer();
	private static StringBuffer unprotectedUserUris = new StringBuffer();
	static{
		
		protectedUserUris.append("/api/business/v1/**")
			.append(",/api/estimates/v1/**")
			.append(",/api/stripePayment/v1/**")
			.append(",/api/additionalAttributes/v1/**")
			.append(",/api/transactions/v1/**")
			.append(",/api/image/v1/**")
			.append(",/api/user/v1/**")
			;
		
		
		/*
		protectedUserUris.append("/api/estimates/v1/**")
		.append("/api/stripePayment/v1/**")
		.append("/api/additionalAttributes/v1/**")
		.append("/api/transactions/v1/**")
		.append("/api/image/v1/**")
		.append("/api/user/v1/**")
		;
		*/
		// Multiple URI should be comma separated in the buffer
		unprotectedUserUris.append("/api/business/v1/searchBusiness");
		//unprotectedUserUris.append("/api/business/v1/searchBusiness").append("/api/business/v1/**");

		// TODO : user management and property management api should be protected via different role
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
			.authorizeRequests().antMatchers(unprotectedUserUris.toString().split(",")).permitAll()
			.and().authorizeRequests().antMatchers(protectedUserUris.toString().split(",")).authenticated()
			.and().oauth2ResourceServer().jwt();
	}
	
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/resources/**");
	}

	@Bean
	JwtDecoder jwtDecoder() {
		NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromOidcIssuerLocation(issuer);

		OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(audience);
		OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
		OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);

		jwtDecoder.setJwtValidator(withAudience);

		return jwtDecoder;
	}

}