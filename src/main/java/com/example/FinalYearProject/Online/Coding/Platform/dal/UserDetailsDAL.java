package com.example.FinalYearProject.Online.Coding.Platform.dal;

import com.example.FinalYearProject.Online.Coding.Platform.domain.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
@Transactional
public interface UserDetailsDAL extends JpaRepository<UserDetails,String> {
    @Transactional
    @Modifying
    @Query("update UserDetails set totalPoints = :points where username=:username")
    public void increasePoints(@Param("username")String username, @Param ("points")int points);

    @Query("select totalPoints from UserDetails where username = :username")
    public int getPointById(@Param("username") String username);
}
