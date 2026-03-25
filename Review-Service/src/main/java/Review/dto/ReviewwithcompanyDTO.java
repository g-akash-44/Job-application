package Review.dto;

import Review.external.Company;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "rid",
    "profile",
    "description",
    "rating",
    "companyId",
    "c"
})
public class ReviewwithcompanyDTO
{
    private Long rid;
    private String profile;
    private String description;
    private double rating;
    private Long companyId;
    private Company c;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Company getC() {
        return c;
    }

    public void setC(Company c) {
        this.c = c;
    }
}
