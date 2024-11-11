package top.mioyi.client

import com.raylib.Jaylib.*
import com.raylib.Raylib
import top.mioyi.scenes.*
import top.mioyi.utils.*

const val WIDTH = 1280
const val HEIGHT = 1024
const val TITLE = "Blokus"
val SCREEN_RECT: Raylib.Rectangle = Rectangle().x(0F).y(0F).width(WIDTH.toFloat()).height(HEIGHT.toFloat())

object App : AutoCloseable {
    var shouldExit = false
    var scene: Scene

    init {
        SetTraceLogLevel(LOG_TRACE)

        InitWindow(WIDTH, HEIGHT, TITLE)
        loadImage("images/icons/icon.png")?.let {
            SetWindowIcon(it)
            UnloadImage(it)
        }
        SetTargetFPS(Int.MAX_VALUE)

        GuiSetStyle(DEFAULT, TEXT_SIZE, 36)
        GuiSetIconScale(3)

        scene = StartScene()
    }

    fun run() {
        while (!WindowShouldClose() && !shouldExit) {
            draw {
                scene.render()
            }
        }
    }

    override fun close() {
        CloseWindow()

        FontResource.close()
    }
}