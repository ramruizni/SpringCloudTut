package com.example.currencyexchangeservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class CurrencyExchangeServiceApplication

fun main(args: Array<String>) {
	runApplication<CurrencyExchangeServiceApplication>(*args)
}
