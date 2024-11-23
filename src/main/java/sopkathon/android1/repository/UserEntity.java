package sopkathon.android1.repository;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "alcohol_degree")
    private Double alcoholDegree;

    @Column(name = "level")
    private Integer level;

    @Column(name = "part")
    private String part;

    @Column(name = "ranking")
    private Integer ranking;

    @Column(name = "sbti")
    private String sbti;

    @Column(name = "is_active")
    private Boolean isActive;
}
