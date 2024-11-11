package top.mioyi.scenes

import com.raylib.Raylib.*
import kotlinx.coroutines.runBlocking
import top.mioyi.client.*
import top.mioyi.client.Language.*
import top.mioyi.graphics.*
import top.mioyi.mainThreadContext

class StartScene : Scene {
    private val titleText = Text(
        I18N.title,
        Rectangle().x(0F).y(0F).width(WIDTH.toFloat()).height(HEIGHT.toFloat() * 2 / 3),
        size = 128F
    )

    private val playButton = Button(
        I18N.playButton,
        ICON_PLAYER_PLAY,
        Rectangle().x(0F).y(HEIGHT.toFloat() / 2).width(WIDTH.toFloat()).height(HEIGHT.toFloat() / 2.2F),
        size = Vector2().x(352F).y(96F),
        alignment = Alignment.TOP_CENTER,
    )

    private val languageButton = Button(
        I18N.languageButton,
        ICON_RESTART,
        Rectangle().x(0F).y(HEIGHT.toFloat() / 2).width(WIDTH.toFloat()).height(HEIGHT.toFloat() / 2.2F),
        size = Vector2().x(448F).y(96F),
        alignment = Alignment.CENTER
    )

    private val exitButton = Button(
        I18N.exitButton,
        ICON_EXIT,
        Rectangle().x(0F).y(HEIGHT.toFloat() / 2).width(WIDTH.toFloat()).height(HEIGHT.toFloat() / 2.2F),
        size = Vector2().x(320F).y(96F),
        alignment = Alignment.BOTTOM_CENTER
    )

    private fun updateLanguages() {
        titleText.setText(I18N.title)
        playButton.setText(I18N.playButton)
        languageButton.setText(I18N.languageButton)
        exitButton.setText(I18N.exitButton)
    }

    override fun render() = runBlocking(mainThreadContext) {
        titleText.render()

        if (playButton.render()) {
            App.scene = JoinScene()
        }

        if (languageButton.render()) {
            when (I18N.language) {
                ENGLISH -> {
                    I18N.language = CHINESE
                    updateLanguages()
                }

                CHINESE -> {
                    I18N.language = JAPANESE
                    updateLanguages()
                }

                JAPANESE -> {
                    I18N.language = ENGLISH
                    updateLanguages()
                }
            }
        }

        if (exitButton.render()) {
            App.shouldExit = true
        }
    }
}