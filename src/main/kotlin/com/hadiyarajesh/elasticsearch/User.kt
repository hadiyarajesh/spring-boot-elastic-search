package com.hadiyarajesh.elasticsearch

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "users")
data class User(
    @Id
    val id: Long,
    @Field(type = FieldType.Text)
    val username: String,
    @Field(type = FieldType.Keyword)
    val email: String,
    @Field(type = FieldType.Text)
    val description: String
)
