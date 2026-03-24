package com.job.Jobs.Jobs.Service;



import com.job.Jobs.Jobs.Entity.Jobs;
import com.job.Jobs.Jobs.dto.jobwithcompanyDTO;

import java.util.List;
import java.util.Optional;

public interface JobService
{
    public String create(Jobs j);

    public List<jobwithcompanyDTO> getall();

    public Optional<Jobs> searchbyid(Long id);

    public String changebyid(Long id);

    public String deletebyid(Long id);
}
