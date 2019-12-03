package com.example.dosclient

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.time.Duration
import java.time.LocalDateTime

@RestController
class AttackController {

    private var log = LoggerFactory.getLogger(this::class.java)
    private val restTemplate = RestTemplate()
    //private val url = "http://localhost:8000/currency-exchange/from/USD/to/INR"
    private val url = "http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR"

    @Async
    @GetMapping("attack/{seconds}")
    fun attack(@PathVariable seconds: Int) {
        log.info("Launching attack...")
        val startTime = LocalDateTime.now()
        while (true) {
            Thread.sleep(200)
            val duration = Duration.between(startTime, LocalDateTime.now())
            if (duration.toMillis() > seconds * 1000) break
            try {
                Thread {
                    kotlin.run { restTemplate.getForEntity(url, Any::class.java).body!! }
                }.start()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        log.info("Attack ended after $seconds seconds.")
    }
}