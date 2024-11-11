package top.mioyi

import kotlinx.coroutines.*
import top.mioyi.client.App
import kotlin.coroutines.CoroutineContext

lateinit var mainThreadContext: CoroutineContext

fun main() = runBlocking {
    mainThreadContext = currentCoroutineContext()

    App.use { it.run() }
}