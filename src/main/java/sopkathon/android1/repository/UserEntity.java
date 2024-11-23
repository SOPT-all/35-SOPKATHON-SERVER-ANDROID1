package sopkathon.android1.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "alcohol_level")
    private Double alcoholLevel;

    @Column(name = "level")
    private Integer level;

    @Column(name = "part")
    private String part;

    @Column(name = "ranking")
    private Integer ranking;

    @Column(name = "jbti")
    private String jbti;

    @Column(name = "is_active")
    private Boolean isActive;

    // 생성자 추가
    public UserEntity(String name, Double alcoholLevel, Integer level, String part, Integer ranking, String jbti) {
        this.name = name;
        this.alcoholLevel = alcoholLevel;
        this.level = level;
        this.part = part;
        this.ranking = ranking;
        this.jbti = jbti;
        this.isActive = true; // 기본값 설정
    }

}
