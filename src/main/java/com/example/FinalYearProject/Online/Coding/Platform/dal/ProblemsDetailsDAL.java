package com.example.FinalYearProject.Online.Coding.Platform.dal;

import com.example.FinalYearProject.Online.Coding.Platform.domain.ProblemDetails;
import com.example.FinalYearProject.Online.Coding.Platform.domain.ProblemTestCaseId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemsDetailsDAL extends JpaRepository<ProblemDetails, ProblemTestCaseId> {
}
