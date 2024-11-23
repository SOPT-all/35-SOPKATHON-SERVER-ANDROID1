package sopkathon.android1.dto.response;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserGetResponseDTO {

    private String name;
    private Double alcoholLevel;
    private int cumulative;
    private String part;
    private String jbti;
    private int ranking;


    public UserGetResponseDTO(String name, Double alcohollLevel, int cumulative, String part, String jbti, int ranking) {
        this.name = name;
        this.alcoholLevel = alcohollLevel;
        this.cumulative = cumulative;
        this.part = part;
        this.jbti = jbti;
        this.ranking = ranking;

    }
}


