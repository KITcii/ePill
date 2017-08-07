package com.doccuty.epill.authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doccuty.epill.model.LoginAttempt;
import com.doccuty.epill.user.SimpleUser;
import com.doccuty.epill.user.SimpleUserRepository;
import com.doccuty.epill.user.User;
import com.doccuty.epill.user.UserRepository;
import com.doccuty.epill.user.UserToken;

@Service
public class AuthenticationService {
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    private SimpleUserRepository<SimpleUser> repository;

    @Autowired
    private LoginAttemptRepository loginAttemptRepository;
    
    private final String JWTSecret = "geheim";

    /**
     * Create a JWT token and additional user information if the user's credentails are valid.
     *
     * @param username username
     * @param password password
     * @return a UserToken or null if the credentials are not valid
     */
    public UserToken login(String username, String password) {
    	
        SimpleUser user = repository.findByUsername(username);

        if(user == null) {
        		return null;
        }

        LoginAttempt loginAttempt = new LoginAttempt();
        loginAttempt.withUserId(user.getId());
        
        String hashedPassword = hashPassword(user.getSalt(), password);

        if (!hashedPassword.equals(user.getPassword())) {
        		loginAttempt.withSuccess(false);
        		loginAttemptRepository.save(loginAttempt);
            LOG.info("User unable to login. user={}", username);
            return null;
        }
        
        String token = Jwts.builder()
                .setSubject(username)
                .setId(""+user.getId())
                .signWith(SignatureAlgorithm.HS512, JWTSecret)
                .compact();
        
        
        UserToken userToken = new UserToken();
        userToken.setUser(user);
        userToken.setToken(token);

    		loginAttempt.withSuccess(true);
    		loginAttemptRepository.save(loginAttempt);
    	
        return userToken;
    }


    /**
     * Validate that a token is valid and returns its body.
     *
     * Throws a SignatureException if the token is not valid.
     * @param jwtToken JWT token
     * @return JWT body
     */
    public Object parseToken(String jwtToken) {
        LOG.debug("Parsing JWT token. JWTtoken={}", jwtToken);
        return Jwts.parser()
                .setSigningKey(JWTSecret)
                .parse(jwtToken)
                .getBody();
    }


    /**
     * Return (salt + password) hashed with SHA-512.
     *
     * The salt is configured in the property authenticationService.salt.
     *
     * @param password plain text password
     * @return hashed password
     */
    public String hashPassword(String salt, String password) {
        return DigestUtils.sha512Hex(salt + password);
    }
}
