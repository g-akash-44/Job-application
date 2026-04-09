package com.job.Jobs.Jobs.ServicesImpl;


import com.job.Jobs.Jobs.Clients.CompanyClient;
import com.job.Jobs.Jobs.Clients.ReviewClients;
import com.job.Jobs.Jobs.Entity.Jobs;
import com.job.Jobs.Jobs.Repository.Jobrepo;
import com.job.Jobs.Jobs.Service.JobService;
import com.job.Jobs.Jobs.dto.jobwithcompanyDTO;
import com.job.Jobs.Jobs.external.Company;
import com.job.Jobs.Jobs.external.Review;
import com.job.Jobs.Jobs.mapper.Jobtocompmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceimpl implements JobService
{
    @Autowired
    private Jobrepo jr;

    @Autowired
    private Jobtocompmapper jc;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CompanyClient cc;

    @Autowired
    private ReviewClients rc;

    public String create(Jobs jobs)
    {
        jr.save(jobs);
        return "Jobs got created";
    }

    public List<jobwithcompanyDTO> getall()
    {
        List<Jobs>j=jr.findAll();
        List<jobwithcompanyDTO> jcl=new ArrayList<>();
        for(Jobs jo:j)
        {
            jobwithcompanyDTO jc=converttoDTO(jo);
            jcl.add(jc);
        }
        return jcl;
    }

    private jobwithcompanyDTO converttoDTO(Jobs j)
    {
        Company c=cc.getcompanybyid(j.getCompanyId());
        Review r=rc.getreviewbyid(j.getReviewId());
        return jc.tojobwithcompDTO(j,c,r);
    }

    public jobwithcompanyDTO searchbyid(Long id)
    {
        Jobs j=jr.findById(id).get();
        return converttoDTO(j);
    }

    public String changebyid(Long id)
    {
        Optional<Jobs> op=jr.findById(id);
        if(!op.isEmpty())
        {
           Jobs j=op.get();
           j.setMaxSalary("6,000");
           jr.save(j);
        }
        return "Data got changed";
    }

    public String deletebyid(Long id)
    {
        Optional<Jobs> jo=jr.findById(id);
        if(jo.isPresent())
        {
            Jobs j=jo.get();
            jr.delete(j);
        }
        return "Data got deleted";
    }

}
