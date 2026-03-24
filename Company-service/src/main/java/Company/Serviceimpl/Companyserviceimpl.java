package Company.Serviceimpl;


import Company.Entity.Company;
import Company.Repo.Companyrepo;
import Company.Service.Companyservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Companyserviceimpl implements Companyservice
{
    @Autowired
    private Companyrepo cr;

    @Override
    public String createCompany(Company c) {
        cr.save(c);
        return "Company got created";
    }

    @Override
    public List<Company> getallcmpy() {
        return cr.findAll();
    }

    @Override
    public Optional<Company> getcmpybyid(Long cid) {
        return cr.findById(cid);
    }

    @Override
    public String updatecmpybyid(Long cid) {
        Company ot=cr.findById(cid).get();
        ot.setName("WTC");
        return "Company got updated";
    }

    @Override
    public String deletecmpybyid(Long cid) {
        Optional<Company> o =cr.findById(cid);
        if(o.isPresent())
        {
            Company c=o.get();
            cr.delete(c);
        }
        return "Company got deleted";
    }

//    @Override
//    public String putjobsincmpy(Integer cid,List<Jobs> j) {
//        Optional<Company> ot =cr.findById(cid);
//        if(ot.isPresent())
//        {
//            Company c=ot.get();
//            c.setJobs(j);
//        }
//        return "Jobs added in company";
//    }
}
