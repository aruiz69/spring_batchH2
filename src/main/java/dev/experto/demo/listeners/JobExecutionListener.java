package dev.experto.demo.listeners;

import org.springframework.batch.core.JobExecution;

public interface JobExecutionListener {
    void beforeJob(JobExecution var1);
    void afterJob(JobExecution var1);
}
