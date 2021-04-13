package com.hadiyarajesh.elasticsearch

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "user")
data class User(
    @Id
    val id: Long,
    @Field(type = FieldType.Keyword)
    val username: String,
    @Field(type = FieldType.Text)
    val fullName: String,
    val age: Int,
    val isActive: Boolean
)
