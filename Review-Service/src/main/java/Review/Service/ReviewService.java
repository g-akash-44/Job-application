package Review.Service;


import Review.Entity.Review;
import org.springframework.stereotype.Service;


public interface ReviewService
{
    public String CreateReview(Review r);

    public Review getreviewbyid(Long rid);


    public String updatereviewbyid(Long rid);

    public String deletereviewbyid(Long rid);


}