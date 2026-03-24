package com.job.Jobs.Jobs.mapper;

import com.job.Jobs.Jobs.Entity.Jobs;
import com.job.Jobs.Jobs.dto.jobwithcompanyDTO;
import com.job.Jobs.Jobs.external.Company;
import org.springframework.stereotype.Component;

@Component
public class Jobtocompmapper
{
    public jobwithcompanyDTO tojobwithcompDTO(Jobs j, Company c)
    {
        jobwithcompanyDTO jobwithcompanyDTO=new jobwithcompanyDTO();
        jobwithcompanyDTO.setId(j.getId());
        jobwithcompanyDTO.setTitle(j.getTitle());
        jobwithcompanyDTO.setDescription(j.getDescription());
        jobwithcompanyDTO.setLocation(j.getLocation());
        jobwithcompanyDTO.setMinSalary(j.getMinSalary());
        jobwithcompanyDTO.setMaxSalary(j.getMaxSalary());
        jobwithcompanyDTO.setCompanyId(j.getCompanyId());
        jobwithcompanyDTO.setCompany(c);
        return jobwithcompanyDTO;
    }
}
