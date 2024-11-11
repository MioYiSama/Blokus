package top.mioyi.graphics

import com.raylib.Raylib.*
import kotlin.experimental.*

private const val BYTE_ZERO = 0.toByte()

enum class Alignment(val flag: Byte) {
    TOP(0b000001),
    H_CENTER(0b000010),
    BOTTOM(0b000100),

    LEFT(0b001000),
    V_CENTER(0b010000),
    RIGHT(0b100000),

    TOP_LEFT(TOP.flag or LEFT.flag),
    TOP_CENTER(TOP.flag or V_CENTER.flag),
    TOP_RIGHT(TOP.flag or RIGHT.flag),

    CENTER_LEFT(H_CENTER.flag or LEFT.flag),
    CENTER(H_CENTER.flag or V_CENTER.flag),
    CENTER_RIGHT(H_CENTER.flag or TOP.flag),

    BOTTOM_LEFT(BOTTOM.flag or LEFT.flag),
    BOTTOM_CENTER(BOTTOM.flag or V_CENTER.flag),
    BOTTOM_RIGHT(BOTTOM.flag or RIGHT.flag);

    private fun match(alignment: Alignment): Boolean {
        return (alignment.flag and flag) != BYTE_ZERO
    }

    fun calculatePos(size: Vector2, rect: Rectangle): Vector2 {
        val x = if (match(LEFT)) {
            0F
        } else if (match(V_CENTER)) {
            (rect.width() - size.x()) / 2
        } else if (match(RIGHT)) {
            rect.width() - size.x()
        } else {
            0F
        }

        val y = if (match(TOP)) {
            0F
        } else if (match(H_CENTER)) {
            (rect.height() - size.y()) / 2
        } else if (match(BOTTOM)) {
            rect.height() - size.y()
        } else {
            0F
        }

        return Vector2()
            .x(x + rect.x())
            .y(y + rect.y())
    }
}