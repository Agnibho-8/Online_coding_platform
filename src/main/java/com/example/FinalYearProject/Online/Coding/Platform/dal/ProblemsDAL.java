package com.example.FinalYearProject.Online.Coding.Platform.dal;

import com.example.FinalYearProject.Online.Coding.Platform.domain.Problems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemsDAL extends JpaRepository<Problems,Integer> {

}
