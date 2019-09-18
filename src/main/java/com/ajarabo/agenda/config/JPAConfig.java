package com.ajarabo.agenda.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.ajarabo.agenda.model")
@EnableJpaRepositories("com.ajarabo.agenda.repository")
public class JPAConfig {

}
