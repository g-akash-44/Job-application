package com.job.Jobs.Jobs.Clients;

import com.job.Jobs.Jobs.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="COMPANY")
public interface CompanyClient
{
    @GetMapping("/company/get")
    Company getcompanybyid(@RequestParam Long id);
}
