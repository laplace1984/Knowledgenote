package com.enthepheron

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class KnowledgenoteApplication

fun main(args: Array<String>) {
    SpringApplication.run(KnowledgenoteApplication::class.java, *args)
}
