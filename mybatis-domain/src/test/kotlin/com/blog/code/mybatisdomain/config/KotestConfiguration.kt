package com.blog.code.mybatisdomain.config

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.extensions.spring.SpringTestExtension
import io.kotest.extensions.spring.SpringTestLifecycleMode

object KotestConfiguration: AbstractProjectConfig() {
    override fun extensions() = listOf(SpringTestExtension(SpringTestLifecycleMode.Root))
}