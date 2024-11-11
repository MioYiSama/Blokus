package top.mioyi.utils

import com.raylib.Jaylib.LoadImageFromMemory
import com.raylib.Raylib.LoadCodepoints
import kotlin.io.path.*

fun loadBytes(path: String) =
    ClassLoader.getSystemResourceAsStream(path)?.use {
        it.readBytes()
    }

fun loadImage(path: String) =
    loadBytes(path)?.let {
        LoadImageFromMemory("." + Path(path).extension, it, it.size)
    }

fun loadCodepoints(text: String) =
    text.toSet()
        .map { LoadCodepoints(it.toString(), count) }
        .flatMap { it.asList() }
        .toIntArray()

private val count = IntArray(1)