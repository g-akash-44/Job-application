package Review.mapper;

import Review.Entity.Review;
import Review.dto.ReviewwithcompanyDTO;
import Review.external.Company;
import org.springframework.stereotype.Component;

@Component
public class Reviewtocompmapper {

    public ReviewwithcompanyDTO mappingtocomp(Review r, Company c)
    {
        ReviewwithcompanyDTO rcd=new ReviewwithcompanyDTO();
        rcd.setRid(r.getRid());
        rcd.setProfile(r.getProfile());
        rcd.setDescription(r.getDescription());
        rcd.setRating(r.getRating());
        rcd.setCompanyId(r.getCompanyId());
        rcd.setC(c);
        return rcd;
    }
}
