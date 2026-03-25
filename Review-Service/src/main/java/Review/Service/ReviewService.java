package Review.Service;


import Review.Entity.Review;
import Review.dto.ReviewwithcompanyDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReviewService
{
    public String CreateReview(Review r);

    public ReviewwithcompanyDTO getreviewbyid(Long rid);


    public String updatereviewbyid(Long rid);

    public String deletereviewbyid(Long rid);

    public List<ReviewwithcompanyDTO> getallreviews();
}