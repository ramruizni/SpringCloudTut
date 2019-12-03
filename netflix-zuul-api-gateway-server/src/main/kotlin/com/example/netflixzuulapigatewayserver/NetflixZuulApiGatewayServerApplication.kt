package com.example.netflixzuulapigatewayserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
class NetflixZuulApiGatewayServerApplication

fun main(args: Array<String>) {
	runApplication<NetflixZuulApiGatewayServerApplication>(*args)
}
