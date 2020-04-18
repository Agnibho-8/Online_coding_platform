package com.example.FinalYearProject.Online.Coding.Platform.dal;

import com.example.FinalYearProject.Online.Coding.Platform.domain.Attempts;
import com.example.FinalYearProject.Online.Coding.Platform.domain.AttemptsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.websocket.server.PathParam;

public interface AttemptsDAL extends JpaRepository<Attempts, AttemptsId> {
   @Query("select att from Attempts att where username=:username")
    public Attempts findByUsername(@Param("username") String username);
}
