package com.job.Jobs.Jobs.dto;


import com.job.Jobs.Jobs.Entity.Jobs;
import com.job.Jobs.Jobs.external.Company;

public class jobwithcompanyDTO {

    private Jobs job;
    private Company comp;

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public Company getComp() {
        return comp;
    }

    public void setComp(Company comp) {
        this.comp = comp;
    }
}
