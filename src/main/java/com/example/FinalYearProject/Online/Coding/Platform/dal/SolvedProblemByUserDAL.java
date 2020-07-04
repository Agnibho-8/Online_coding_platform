package com.example.FinalYearProject.Online.Coding.Platform.dal;

import com.example.FinalYearProject.Online.Coding.Platform.domain.SolvedProblemsByUser;
import com.example.FinalYearProject.Online.Coding.Platform.domain.UserProblemID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SolvedProblemByUserDAL extends JpaRepository<SolvedProblemsByUser,UserProblemID> {

    @Query("select isSolved from SolvedProblemsByUser where userProblemID = :userProblemID")
    public boolean isSolved(@Param("userProblemID") UserProblemID userProblemID);
    
}
