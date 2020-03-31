package com.example.FinalYearProject.Online.Coding.Platform.dal;

import com.example.FinalYearProject.Online.Coding.Platform.domain.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsDAL extends JpaRepository<UserDetails,String> {
}
