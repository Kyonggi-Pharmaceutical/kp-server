package kr.ac.kgu.kpserver.domain.user;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import kr.ac.kgu.kpserver.config.OAuth2Property;
import kr.ac.kgu.kpserver.domain.user.dto.UserRequest;
import kr.ac.kgu.kpserver.security.JwtAuthenticator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtAuthenticator jwtAuthenticator;
    private final GoogleIdTokenVerifier verifier;


    private static final String FIRST_NAME = "given_name";
    private static final String LAST_NAME = "family_name";
    private static final String PROFILE_IMAGE_URL = "picture";

    public UserService(UserRepository userRepository, JwtAuthenticator jwtAuthenticator, OAuth2Property oAuth2Property) {
        this.userRepository = userRepository;
        this.jwtAuthenticator = jwtAuthenticator;

        NetHttpTransport transport = new NetHttpTransport();
        GsonFactory gsonFactory = new GsonFactory();

        verifier = new GoogleIdTokenVerifier.Builder(transport, gsonFactory)
                .setAudience(Collections.singletonList(oAuth2Property.getGoogle().getClientId()))
                .build();
    }

    @Transactional(readOnly = true)
    public User findUserByIdOrNull(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public String loginWithOAuth2Google(String idToken) {
        User user = parseUserFromIdTokenOrNull(idToken);
        if (user == null) {
            log.warn("### user authentication failed with idToken:" + idToken);
            throw new AuthenticationCredentialsNotFoundException("auth failed");
        }
        user = upsertUser(user);
        return jwtAuthenticator.createToken(user, false);
    }

    @Transactional
    public User updateUser(User user, UserRequest userRequest) {
        User updatedUser = user.update(
                userRequest.getGender(),
                userRequest.getDateOfBirth(),
                userRequest.getHeight(),
                userRequest.getWeight(),
                userRequest.getMbti(),
                userRequest.getExerciseGroup(),
                userRequest.getStressPoint(),
                userRequest.getIsSmoking(),
                userRequest.getIsAlcohol()
        );
        return userRepository.save(updatedUser);
    }

    private User upsertUser(User userRequest) {
        User user = userRepository.findByEmail(userRequest.getEmail()).orElse(userRequest);
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setProfileImageUrl(userRequest.getProfileImageUrl());
        return userRepository.save(user);
    }

    private User parseUserFromIdTokenOrNull(String idToken) {
        try {
            GoogleIdToken googleIdToken = verifier.verify(idToken);
            GoogleIdToken.Payload payload = googleIdToken.getPayload();
            String firstName = (String) payload.get(FIRST_NAME);
            String lastName = (String) payload.get(LAST_NAME);
            String email = payload.getEmail();
            String profileImageUrl = (String) payload.get(PROFILE_IMAGE_URL);

            return new User(firstName, lastName, email, profileImageUrl);
        } catch (GeneralSecurityException | IOException e) {
            return null;
        }
    }
}
