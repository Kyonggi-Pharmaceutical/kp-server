package kr.ac.kgu.kpserver.domain.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private final String firstName;
    private final String lastName;
    private String email;

    public static UserDto from(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
}
