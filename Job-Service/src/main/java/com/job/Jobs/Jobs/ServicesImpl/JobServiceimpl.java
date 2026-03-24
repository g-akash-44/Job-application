package com.job.Jobs.Jobs.ServicesImpl;


import com.job.Jobs.Jobs.Entity.Jobs;
import com.job.Jobs.Jobs.Repository.Jobrepo;
import com.job.Jobs.Jobs.Service.JobService;
import com.job.Jobs.Jobs.dto.jobwithcompanyDTO;
import com.job.Jobs.Jobs.external.Company;
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
        jobwithcompanyDTO jc=new jobwithcompanyDTO();
        if(j!=null)
        {
            jc.setJob(j);
        }
        RestTemplate rs=new RestTemplate();
        Company c=rs.getForObject("http://localhost:8082/company/get?id="+ j.getCompanyId(), Company.class);
        jc.setComp(c);
        return jc;
    }

    public Optional<Jobs> searchbyid(Long id)
    {
        return jr.findById(id);
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
