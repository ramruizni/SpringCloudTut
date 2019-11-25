package com.example.netflixeurekanamingservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class NetflixEurekaNamingServiceApplication

fun main(args: Array<String>) {
	runApplication<NetflixEurekaNamingServiceApplication>(*args)
}
