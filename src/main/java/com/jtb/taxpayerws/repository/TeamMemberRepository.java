package com.jtb.taxpayerws.repository;

import com.jtb.taxpayerws.entity.TeamMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMemberEntity, String> {


    @Query(value = "SELECT * FROM team_table WHERE email = :email", nativeQuery = true)
    Optional<TeamMemberEntity> findByEmail(String email);

    @Query(value = "SELECT * FROM team_table WHERE id = :id", nativeQuery = true)
    Optional<TeamMemberEntity> findTeamMemberById(@Param("id") Long id);

    void deleteById(Long id);

}
