package com.jay.jpa.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy

@Configuration
class DataConfig {
    @Value("\${spring.datasource.url}")
    lateinit var url: String

    @Value("\${spring.datasource.username}")
    lateinit var user: String

    @Value("\${spring.datasource.password}")
    lateinit var pass: String

    @Value("\${spring.datasource.classname}")
    lateinit var srcClass: String

    @Lazy
    @Bean(destroyMethod = "close")
    fun getDataSource(): HikariDataSource = HikariDataSource(HikariConfig().apply {
        username = user
        password = pass
        addDataSourceProperty("url", url)
        dataSourceClassName = srcClass
        leakDetectionThreshold = 2000
        poolName = "example maria database"
    })
}