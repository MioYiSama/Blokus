package top.mioyi.scenes

import com.raylib.Raylib.*
import top.mioyi.client.*
import top.mioyi.graphics.Button

class JoinScene : Scene {
    private val backButton = Button(
        I18N.backButton,
        ICON_PLAYER_PLAY_BACK,
        Rectangle().x(0F).y(HEIGHT.toFloat() * 2 / 3).width(WIDTH.toFloat()).height(HEIGHT.toFloat() / 3),
    )

    private val secretViewActive = BooleanArray(1)
    private val messageBuffer = ByteArray(64)

    override fun render() {
        GuiSetFont(GetFontDefault())
        GuiTextBox(Rectangle().x(0F).y(100F).width(640F).height(200F), messageBuffer, 64, true)

        if (backButton.render()) {
            App.scene = StartScene()
        }
    }
}