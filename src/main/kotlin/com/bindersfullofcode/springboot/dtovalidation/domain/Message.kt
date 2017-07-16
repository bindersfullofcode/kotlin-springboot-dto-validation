package com.bindersfullofcode.springboot.dtovalidation.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Message(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id : Long = -1,
        val content: String,
        val to: String,
        val createdAt: Date = Date()) {
}