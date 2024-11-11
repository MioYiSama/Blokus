package top.mioyi.graphics

import com.raylib.Jaylib
import com.raylib.Raylib.*
import kotlinx.coroutines.withContext
import top.mioyi.client.*
import top.mioyi.mainThreadContext

private const val SPACING = 0F

class Text(
    private var text: String,
    private val rect: Rectangle = SCREEN_RECT,
    private val alignment: Alignment = Alignment.CENTER,
    private val size: Float = 24F,
    private val color: Color = Jaylib.BLACK
) {
    private var font = FontResource.getFont(text)
    private var pos = alignment.calculatePos(MeasureTextEx(font, text, size, SPACING), rect)

    suspend fun render() = withContext(mainThreadContext) {
        DrawTextEx(font, text, pos, size, SPACING, color)
    }

    fun setText(text: String) {
        this.text = text
        this.font = FontResource.getFont(text)
        pos = alignment.calculatePos(MeasureTextEx(font, text, size, SPACING), rect)
    }
}