package com.ust.TrainerJobNotifications.repo;

import com.ust.TrainerJobNotifications.model.Jobinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends JpaRepository<Jobinfo, Integer> {
}
