package com.job.Jobs.Jobs.Clients;

import com.job.Jobs.Jobs.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="REVIEW")
public interface ReviewClients
{
    @GetMapping("/review/get/{id}")
    Review getreviewbyid(@PathVariable  Long id);
}
