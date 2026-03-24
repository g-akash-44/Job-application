package Company.Service;


import Company.Entity.Company;

import java.util.List;
import java.util.Optional;

public interface Companyservice
{
    public String createCompany(Company c);

    public List<Company> getallcmpy();

    public Optional<Company> getcmpybyid(Long cid);

    public String updatecmpybyid(Long cid);

    public String deletecmpybyid(Long cid);

//    public String putjobsincmpy(Integer cid, List<Jobs> j);
}
