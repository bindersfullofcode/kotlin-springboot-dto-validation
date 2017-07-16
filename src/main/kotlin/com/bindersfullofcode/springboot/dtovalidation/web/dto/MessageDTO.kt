package com.bindersfullofcode.springboot.dtovalidation.web.dto

import com.bindersfullofcode.springboot.dtovalidation.domain.Message
import org.hibernate.validator.constraints.NotEmpty

class MessageDTO {
    @NotEmpty
    lateinit var to : String
    @NotEmpty
    lateinit var content: String

    fun toMessage() = Message(to = to, content = content)
}