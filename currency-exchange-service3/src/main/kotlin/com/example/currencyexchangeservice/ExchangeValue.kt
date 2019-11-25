package com.example.currencyexchangeservice

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class ExchangeValue(
        @Id
        val id: Long,
        @Column(name="currency_from")
        val from: String,
        @Column(name="currency_to")
        val to: String,
        @Column(name="conversion_value")
        val value: BigDecimal,
        var port: Int
)