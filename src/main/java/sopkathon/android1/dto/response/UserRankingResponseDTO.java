package sopkathon.android1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class UserRankingResponseDTO {
    private final LoginUserDTO loginUser;

    private final List<RankingDTO> rankings;
}
