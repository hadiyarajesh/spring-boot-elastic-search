package com.hadiyarajesh.elasticsearch.configs

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "app.elasticsearch")
data class ElasticsearchProperties(
    val host: String,
    val port: Int
)