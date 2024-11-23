package sopkathon.android1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByIsActive(Boolean isActive);

    @Query(
            "SELECT u " +
            "FROM UserEntity u " +
            "WHERE u.part = :part"
    )
    List<UserEntity> userRankByPart(@Param("part") String part);

    @Query(
            "SELECT COUNT(u) + 1 " +
            "FROM UserEntity u " +
            "WHERE u.alcoholLevel > (SELECT target.alcoholLevel FROM UserEntity target WHERE target.isActive = true)"
    )
    int findUserRank();

    @Query(
            "SELECT COUNT(u) + 1 " +
                    "FROM UserEntity u " +
                    "WHERE u.alcoholLevel > (SELECT target.alcoholLevel FROM UserEntity target WHERE target.isActive = true AND target.part = :part) " +
                    "AND u.part = :part"
    )
    int findUserRankByPart(@Param("part") String part);

    @Query("SELECT u FROM UserEntity u ORDER BY u.alcoholLevel DESC")
    List<UserEntity> findAllRank();

    @Query(
            "SELECT u FROM UserEntity u " +
                    "WHERE u.part = :part " +
                    "ORDER BY u.alcoholLevel DESC"
    )
    List<UserEntity> findAllRankWithPart(@Param("part") String part);


}

