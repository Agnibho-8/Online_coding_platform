package com.example.FinalYearProject.Online.Coding.Platform.dal;

import com.example.FinalYearProject.Online.Coding.Platform.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;
@Repository
@Transactional
public interface UserDAL extends JpaRepository<User,String> {
    @Query("select password from User where username=:usernam")
public String findPassword(@PathParam("usernam") String usernam);

}
