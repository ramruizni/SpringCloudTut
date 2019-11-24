package com.example.limitsservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LimitsConfigController {

    @Autowired
    private lateinit var config: Configuration

    @GetMapping("/limits")
    fun getLimitsFromConfig(): LimitsConfig {
        return LimitsConfig(config.maximum!!, config.minimum!!)
    }

}