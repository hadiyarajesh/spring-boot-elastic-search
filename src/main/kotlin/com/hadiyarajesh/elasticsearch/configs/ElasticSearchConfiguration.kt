package com.hadiyarajesh.elasticsearch.configs

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration

@Configuration
class ElasticSearchConfiguration(
        private val elasticsearchProperties: ElasticsearchProperties
) : AbstractElasticsearchConfiguration() {
    @Bean
    override fun elasticsearchClient(): RestHighLevelClient {
        val clientConfiguration = ClientConfiguration.builder()
                .connectedTo("${elasticsearchProperties.host}:${elasticsearchProperties.port}")
                .build()

        return RestClients.create(clientConfiguration).rest()
    }
}