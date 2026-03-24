package Review.ServiceImpl;


import Review.Entity.Review;
import Review.Repo.Reviewrepo;
import Review.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewServiceimpl implements ReviewService
{
    @Autowired
    private Reviewrepo rr;

    @Override
    public String CreateReview(Review r)
    {
        rr.save(r);
        return "Review Just got created";
    }

    @Override
    public Review getreviewbyid(Long rid) {
        Review r=rr.findById(rid).get();
        return r;
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
}
