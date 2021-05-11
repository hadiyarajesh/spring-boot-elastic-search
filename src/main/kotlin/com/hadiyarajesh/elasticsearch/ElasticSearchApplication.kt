package com.hadiyarajesh.elasticsearch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class ElasticSearchApplication

fun main(args: Array<String>) {
    runApplication<ElasticSearchApplication>(*args)
}
