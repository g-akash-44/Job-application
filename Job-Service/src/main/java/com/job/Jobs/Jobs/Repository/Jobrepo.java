package com.job.Jobs.Jobs.Repository;


import com.job.Jobs.Jobs.Entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Jobrepo extends JpaRepository<Jobs, Long>
{

}
