package top.mioyi.graphics

import com.raylib.Raylib.*
import top.mioyi.client.*

class Button(
    private var text: String,
    private val icon: Int,
    rect: Rectangle = SCREEN_RECT,
    size: Vector2 = Vector2().x(256F).y(96F),
    alignment: Alignment = Alignment.CENTER
) {
    private var font = FontResource.getFont(text)

    private val bound = run {
        val pos = alignment.calculatePos(size, rect)

        Rectangle().x(pos.x()).y(pos.y()).width(size.x()).height(size.y())
    }

    fun render(): Boolean {
        GuiSetFont(font)
        return GuiButton(bound, GuiIconText(icon, " $text")) != 0
    }

    fun setText(text: String) {
        this.text = text
        this.font = FontResource.getFont(text)
    }
}