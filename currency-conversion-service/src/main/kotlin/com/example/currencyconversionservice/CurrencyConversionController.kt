package com.example.currencyconversionservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@RestController
class CurrencyConversionController {

    @Autowired
    private var proxy: CurrencyExchangeServiceProxy? = null

    @GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    fun getCurrencyConversionFeign(@PathVariable from: String, @PathVariable to: String, @PathVariable quantity: Int): CurrencyConversion {
        val currencyConversion = proxy!!.getCurrencyExchange(from, to)
        currencyConversion.quantity = quantity.toBigDecimal()
        currencyConversion.totalCalculatedAmount = currencyConversion.value*currencyConversion.quantity!!
        return currencyConversion
    }
}