package com.enthepheron.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
open class WebMvcConfig : WebMvcConfigurerAdapter() {

    override fun addViewControllers(registry: ViewControllerRegistry?) {
        // Resolve login view page.
        registry!!.addViewController("/login").setViewName("login")
        // Main page
//        registry.addViewController("/main").setViewName("main")
    }
}