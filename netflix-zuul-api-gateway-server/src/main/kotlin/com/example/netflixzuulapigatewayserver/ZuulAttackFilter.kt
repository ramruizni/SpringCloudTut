package com.example.netflixzuulapigatewayserver

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.LocalDateTime
import java.util.*


@Component
class ZuulAttackFilter : ZuulFilter() {

    private val lastIPs: Queue<String> = LinkedList<String>()
    private val lastTimes: Queue<LocalDateTime> = LinkedList<LocalDateTime>()

    override fun run(): Any? {
        val ctx = RequestContext.getCurrentContext()

        if (lastIPs.size == 2) {
            lastIPs.remove(); lastTimes.remove()
        }

        lastIPs.add(ctx.request.remoteAddr)
        lastTimes.add(LocalDateTime.now())

        if (lastIPs.size >= 2 && Duration.between(lastTimes.peek(), lastTimes.elementAt(1)).toMillis() < 500
                && lastIPs.peek() == lastIPs.elementAt(1)) {
            ctx.responseStatusCode = 401
            if (ctx.responseBody == null) {
                ctx.responseBody = "Too many simultaneous requests from this client"
                ctx.setSendZuulResponse(false)
            }
        }
        return null
    }

    override fun shouldFilter(): Boolean {
        return true
    }

    override fun filterType(): String {
        return "pre"
    }

    override fun filterOrder(): Int {
        return 1
    }
}