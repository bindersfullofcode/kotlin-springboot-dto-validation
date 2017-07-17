package com.bindersfullofcode.springboot.dtovalidation.web

import com.bindersfullofcode.springboot.dtovalidation.domain.Message
import com.bindersfullofcode.springboot.dtovalidation.domain.MessageRepository
import com.bindersfullofcode.springboot.dtovalidation.web.dto.MessageDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages")
class MessageController @Autowired constructor (val messageRepository: MessageRepository) {

    @GetMapping
    fun getAllMessages() : List<Message> = messageRepository.findAll().toList()

    @GetMapping("/{messageId}")
    fun getMessageById(@PathVariable messageId : Long) : Message? = messageRepository.findOne(messageId)

    @PostMapping
    fun createMessage(@RequestBody @Validated messageDto: MessageDTO) {
        val message = messageDto.toMessage()

        messageRepository.save(message)
    }

    @PutMapping("/{messageId}")
    fun updateMessage(@PathVariable messageId: Long, @RequestBody @Validated messageDto: MessageDTO) {
        val message = messageRepository.findOne(messageId)

        message?.let {
            it.to = messageDto.to
            it.content = messageDto.content

            messageRepository.save(message)
        }
    }

    @DeleteMapping("/{messageId}")
    fun deleteMessage(@PathVariable messageId: Long) = messageRepository.delete(messageId)
}