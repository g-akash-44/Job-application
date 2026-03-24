package Review.Controller;


import Review.Entity.Review;
import Review.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController
{
    @Autowired
    private ReviewService rs;

    @PostMapping("/createReview")
    public ResponseEntity<String> create(@RequestBody Review r)
    {
        return new ResponseEntity<String>(rs.CreateReview(r),HttpStatus.CREATED);
    }

    @GetMapping("/get/{rid}")
    public ResponseEntity<Review> getreviewbycid(@PathVariable Long rid)
    {
        return new ResponseEntity<Review>(rs.getreviewbyid(rid),HttpStatus.OK);
    }

    @PutMapping("/update/{rid}")
    public ResponseEntity<String> updatereviewbycid(@PathVariable Long rid)
    {
        return new ResponseEntity<String>(rs.updatereviewbyid(rid),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{rid}")
    public ResponseEntity<String> deletereview(@PathVariable Long rid)
    {
        return new ResponseEntity<String>(rs.deletereviewbyid(rid),HttpStatus.ACCEPTED);
    }
 }
