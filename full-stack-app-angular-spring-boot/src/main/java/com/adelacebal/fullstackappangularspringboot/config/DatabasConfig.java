package com.adelacebal.fullstackappangularspringboot.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.adelacebal.fullstackappangularspringboot.repository")
@EnableTransactionManagement
public class DatabasConfig {

}
