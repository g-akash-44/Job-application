package Review.ServiceImpl;


import Review.Entity.Review;
import Review.Repo.Reviewrepo;
import Review.Service.ReviewService;
import Review.dto.ReviewwithcompanyDTO;
import Review.external.Company;
import Review.mapper.Reviewtocompmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewServiceimpl implements ReviewService
{
    @Autowired
    private Reviewrepo rr;

    @Autowired
    private RestTemplate rs;

    @Autowired
    private Reviewtocompmapper rtm;

    @Override
    public String CreateReview(Review r)
    {
        rr.save(r);
        return "Review Just got created";
    }

    @Override
    public ReviewwithcompanyDTO getreviewbyid(Long rid) {
        Review r=rr.findById(rid).get();
        Company c=rs.getForObject("http://COMPANY:8082/company/get?id="+ r.getCompanyId(), Company.class);
        ReviewwithcompanyDTO rcd=rtm.mappingtocomp(r,c);
        return rcd;
    }

    @Override
    public String updatereviewbyid(Long rid) {
        Review r=rr.findById(rid).get();
        r.setDescription("Rating for WTC");
        rr.save(r);
        return "Review Got Updated";
    }

    @Override
    public String deletereviewbyid(Long rid) {
        Review r=rr.findById(rid).get();
        rr.delete(r);
        return "Review got deleted";
    }

    @Override
    public List<ReviewwithcompanyDTO> getallreviews()
    {
        List<Review> r=rr.findAll();
        List<ReviewwithcompanyDTO> rcl=new ArrayList<>();
        for(Review re:r)
        {
            ReviewwithcompanyDTO rcd=converttoDTO(re);
            rcl.add(rcd);
        }
        return  rcl;
    }

    private ReviewwithcompanyDTO converttoDTO(Review re) {
        Company c=rs.getForObject("http://COMPANY:8082/company/get?id="+ re.getCompanyId(), Company.class);
        ReviewwithcompanyDTO rcd=new ReviewwithcompanyDTO();
        rcd.setRid(re.getRid());
        rcd.setProfile(re.getProfile());
        rcd.setDescription(re.getDescription());
        rcd.setRating(re.getRating());
        rcd.setCompanyId(re.getCompanyId());
        rcd.setC(c);
        return rcd;
    }
}
