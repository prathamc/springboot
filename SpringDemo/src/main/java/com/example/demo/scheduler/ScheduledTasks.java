package com.example.demo.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.mongo.model.MongoEmployee;
import com.example.demo.mongo.repository.EmployeeRepository;

@Component
public class ScheduledTasks {


	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	
	@Autowired
	EmployeeRepository empRepo ;
	
	@Autowired
    JobLauncher jobLauncher;
 
    @Autowired
    Job processJob;

/*	@Scheduled(fixedDelay = 300000)
	public void scheduleTaskWithFixedRate() {
		 logger.info("Spring batch Job execution started : ", dateTimeFormatter.format(LocalDateTime.now()) );
		 JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                 .toJobParameters();
         try {
			jobLauncher.run(processJob, jobParameters);
			logger.info("Job has been launched");
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
	}
	
	
	
	
	
	@Scheduled(fixedDelay=2000)
	public void scheduleTaskWithFixedDelay() {
		logger.info("Fixed Delay Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		
		MongoEmployee insert = empRepo.insert(new MongoEmployee(saltStr.toString()));
		logger.info("Employee Added : " + insert.toString());
		
	}*/

	/*@Scheduled(fixedRate = 2000, initialDelay = 5000)
	public void scheduleTaskWithInitialDelay() {
	    logger.info("Fixed Rate Task with Initial Delay :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
	}*/

	public void scheduleTaskWithCronExpression() {}
}
