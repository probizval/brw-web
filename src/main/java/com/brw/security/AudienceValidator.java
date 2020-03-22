package com.brw.security;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

public class AudienceValidator implements OAuth2TokenValidator<Jwt> {

	private final String audience;
	
	public AudienceValidator(String audience) {
		this.audience=audience;
	}
	
	@Override
	public OAuth2TokenValidatorResult validate(Jwt token) {
		OAuth2Error error = new OAuth2Error("invalid_token", "The required audience is missing", null);
		//scope
        //System.out.println("Validating the bearer token for audience - "+ token.getAudience());
        //System.out.println("scope for user" + token.getClaimAsString("scope"));
        
        //;
        if (token.getAudience().contains(audience)  || 
        		token.getClaimAsString("scope").contains("all:api")) {
            return OAuth2TokenValidatorResult.success();
        }
        return OAuth2TokenValidatorResult.failure(error);
		
	}

}
