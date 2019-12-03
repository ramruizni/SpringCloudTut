package com.example.currencyexchangeservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CurrencyExchangeController {

    @Autowired
    private var environment: Environment? = null

    @Autowired
    private var repository: ExchangeValueRepository? = null

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    fun getCurrencyExchange(@PathVariable from: String, @PathVariable to: String): ExchangeValue {
        val exchangeValue = repository!!.findByFromAndTo(from, to)

        exchangeValue.port = environment!!.getProperty("local.server.port")!!.toInt()
        Thread.sleep(1000)
        return exchangeValue
    }
}