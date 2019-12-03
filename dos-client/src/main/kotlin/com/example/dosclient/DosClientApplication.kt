package com.example.dosclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync


@EnableAsync
@SpringBootApplication
class DosClientApplication

fun main(args: Array<String>) {
    runApplication<DosClientApplication>(*args)
}
