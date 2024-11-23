package sopkathon.android1.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserCreateRequestDTO {
    private String name;
    private int level;
    private String part;
    private String jbti;
    private Double soju;
    private Double beer;
    private Double makgeolli;
    private Double wine;

    public UserCreateRequestDTO(String name,int level, String part,Double soju,Double beer,Double makgeolli, Double wine){
        this.name = name;
        this.level = level;
        this.part = part;
        this.jbti = jbti;
        this.soju = soju;
        this.beer = beer;
        this.makgeolli = makgeolli;
        this.wine = wine;


    }


}
