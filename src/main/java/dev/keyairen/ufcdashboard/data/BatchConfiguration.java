package dev.keyairen.ufcdashboard.data;

import dev.keyairen.ufcdashboard.model.Fight;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {

    private final String[] FIELD_NAMES = new String[] {
        "Id",
        "EventName",
        "RedFighter",
        "BlueFighter",
        "Date",
        "Location",
        "Country",
        "Winner",
        "TitleBout",
        "WeightClass",
        "Gender",
        "NumberOfRounds",
        "BlueDraws",
        "BlueLosses",
        "BlueWins",
        "BlueStance",
        "BlueHeightCms",
        "BlueReachCms",
        "BlueWeightLbs",
        "RedDraws",
        "RedLosses",
        "RedWins",
        "RedStance",
        "RedHeightCms",
        "RedReachCms",
        "RedWeightLbs",
        "RedAge",
        "BlueAge",
        "Finish",
        "FinishDetails",
    };

    @Bean
    public FlatFileItemReader<FightInput> reader() {
        return new FlatFileItemReaderBuilder<FightInput>()
                .name("FightItemReader")
                .resource(new ClassPathResource("fight-data.csv"))
                .delimited()
                .names(FIELD_NAMES)
                .targetType(FightInput.class)
                .build();
    }

    @Bean
    public FightDataProcessor processor() {
        return new FightDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Fight> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Fight>()
                .sql("INSERT INTO fight (id, event_name, red_fighter, blue_fighter, date, location, country, winner, title_bout, weight_class, gender, number_of_rounds, blue_draws, blue_losses, blue_wins, blue_stance, blue_height_cms, blue_reach_cms, blue_weight_lbs, red_draws, red_losses, red_wins, red_stance, red_height_cms, red_reach_cms, red_weight_lbs, red_age, blue_age, finish, finish_details)"
                        + "VALUES (:id, :eventName, :redFighter, :blueFighter, :date, :location, :country, :winner, :titleBout, :weightClass, :gender, :numberOfRounds, :blueDraws, :blueLosses, :blueWins, :blueStance, :blueHeightCms, :blueReachCms, :blueWeightLbs, :redDraws, :redLosses, :redWins, :redStance, :redHeightCms, :redReachCms, :redWeightLbs, :redAge, :blueAge, :finish, :finishDetails)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository, Step step1, JobCompletionNotificationListener listener) {
        return new JobBuilder("importUserJob", jobRepository)
                .listener(listener)
                .start(step1)
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager,
                      FlatFileItemReader<FightInput> reader, FightDataProcessor processor, JdbcBatchItemWriter<Fight> writer) {
        return new StepBuilder("step1", jobRepository)
                .<FightInput, Fight>chunk(3, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}