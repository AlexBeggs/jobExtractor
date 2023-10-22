package com.goodforallcode.jobExtractor.filters.deep;

import com.goodforallcode.jobExtractor.filters.JobFilter;
import com.goodforallcode.jobExtractor.model.Job;
import com.goodforallcode.jobExtractor.model.preferences.Preferences;

import java.util.List;

public class PerformanceFilter implements JobFilter {

    List<String> phrases =List.of("profiling","optimizing","Tuning","Onestream"," cpm ");

    public boolean include(Preferences preferences, Job job){
        String description =job.getDescription().toLowerCase();
     if (phrases.stream().anyMatch(p->description.contains(p.toLowerCase()))) {
         System.err.println("performance->reject: " + job);
         return false;
     }

     return true;

 }
}
