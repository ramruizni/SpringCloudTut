package com.example.currencyconversionservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients("com.example.currencyconversionservice")
@EnableDiscoveryClient
@SpringBootApplication
class CurrencyConversionServiceApplication

fun main(args: Array<String>) {
	runApplication<CurrencyConversionServiceApplication>(*args)
}
