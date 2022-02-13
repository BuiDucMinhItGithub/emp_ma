package com.emp_ma.configuration;


import com.emp_ma.listener.JobListener;
import com.emp_ma.model.dto.EmployeeDto;
import com.emp_ma.model.entity.Employee;
import com.emp_ma.processor.EmployeeProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    @Bean
    public FlatFileItemReader<Employee> reader() {
        FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
        reader.setResource(new ClassPathResource("employee.csv"));

        reader.setLineMapper(new DefaultLineMapper<Employee>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "fullname","username","birthday","email","gender", "password", "address", "number", "hire_date", "status", "department_id" });
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper() {{
                setTargetType(Employee.class);
            }});
        }});
        return reader;
    }

    @Bean
    public EmployeeProcessor processor() {
        return new EmployeeProcessor();
    }
    @Bean
    public JdbcBatchItemWriter<EmployeeDto> writer() {
        JdbcBatchItemWriter<EmployeeDto> writer = new JdbcBatchItemWriter<EmployeeDto>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO tbl_employee (fullname,username,birthday,email,gender,password,address,number,hire_date,status,department_id) " +
                "VALUES (:fullname, :birthday, :email, :gender,:password,:address,:number,:hire_date,:status, :department_id)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public Job importUserJob(JobListener jobListener) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(jobListener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Employee, EmployeeDto> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }


}
