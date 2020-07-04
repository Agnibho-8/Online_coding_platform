package com.example.FinalYearProject.Online.Coding.Platform.dal;

import com.example.FinalYearProject.Online.Coding.Platform.domain.Problems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProblemsDAL extends JpaRepository<Problems,Integer> {

    @Query ("select pointsAlotted from Problems p where p.problemId=:id")
    public int findPointsByProblemId(@Param("id") int id);
}
