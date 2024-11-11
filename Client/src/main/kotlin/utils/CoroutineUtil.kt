package top.mioyi.utils

import kotlinx.coroutines.*
import top.mioyi.mainThreadContext

suspend inline fun <T> onMainThread(crossinline f: suspend CoroutineScope.() -> T): T =
    withContext(mainThreadContext) { f() }