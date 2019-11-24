package com.example.currencyconversionservice

import java.math.BigDecimal


data class CurrencyConversion(
        val id: Long,
        val from: String,
        val to: String,
        val value: BigDecimal,
        var quantity: BigDecimal?,
        var totalCalculatedAmount: BigDecimal?,
        var port: Int
)