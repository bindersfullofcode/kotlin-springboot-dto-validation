package com.bindersfullofcode.springboot.dtovalidation.domain

import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, Long>