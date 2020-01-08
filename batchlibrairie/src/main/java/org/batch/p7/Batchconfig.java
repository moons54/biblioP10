package org.batch.p7;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@Configuration
@EnableBatchProcessing
public class Batchconfig {


    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public Step stepOne(){
        return steps.get("stepOne")
                .tasklet(new Tache1())
                .build();
    }

    /**TICKET 2
     * Il s'agit ici de l'étape deux ayant pour objectif la modification du status
     * du lecteur lorsque celui ci n'a pas rendu le livre à temps
     * @return
     */
    @Bean
    public Step stepTwo(){
        return steps.get("stepTwo")
                .tasklet(new Tache2())
                .build();
    }

    @Bean
    public Step stepThree(){
        return steps.get("stepThree")
                .tasklet(new Tache3())
                .build();
    }
    @Bean
    public Step stepFour(){
        return steps.get("stepFour")
                .tasklet(new Tache4())
                .build();
    }

    @Bean
    public Step stepSix(){
        return steps.get("stepsix")
                .tasklet(new Tache6())
                .build();
    }

    @Bean
    public Step stepSeven(){
        return steps.get("stepsever")
                .tasklet(new Tache7())
                .build();
    }

    @Bean
    public Step stepEight(){
        return steps.get("stepeight")
                .tasklet(new Tache8())
                .build();
    }

    @Bean
    public Job demoJob(){
        return jobs.get("demoJob")
                .incrementer(new RunIdIncrementer())
                .start(stepTwo())
           //     .next(stepOne())
                .next(stepFour())
                .next(stepThree())
                .next(stepSix())
                .next(stepSeven())
                .next(stepEight())
                .build();
    }


}