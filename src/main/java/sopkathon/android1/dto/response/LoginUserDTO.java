package sopkathon.android1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class LoginUserDTO {
    private final String name;

    private final String imageUrl;

    private final String part;

    private final Integer ranking;

    private final Double jpLevel;

    private final String jbti;

    private Boolean isLoginUser;
}