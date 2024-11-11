package top.mioyi.utils

import com.raylib.Jaylib.*
import top.mioyi.client.I18N
import kotlin.time.measureTime

inline fun draw(f: () -> Unit) {
    val beginTime = measureTime {
        BeginDrawing()
        ClearBackground(RAYWHITE)
    }

    val drawTime = measureTime {
        f()
    }

    val endTime = measureTime {
        DrawFPS(0, 0)
        EndDrawing()
    }

    SetWindowTitle("${I18N.title} | Begin: $beginTime | Draw: $drawTime | End: $endTime")
}