package top.mioyi.client

import top.mioyi.client.Language.*

enum class Language(val displayName: String) {
    ENGLISH("English"),
    CHINESE("中文"),
    JAPANESE("日本語")
}

object I18N {
    var language = ENGLISH

    val title
        get() = when (language) {
            CHINESE -> "角斗士棋"
            ENGLISH -> "Blokus"
            JAPANESE -> "ブロックス"
        }

    val backButton
        get() = when (language) {
            CHINESE -> "返回"
            ENGLISH -> "Go back"
            JAPANESE -> "戻る"
        }

    val playButton
        get() = when (language) {
            CHINESE -> "开始游戏"
            ENGLISH -> "Start Game"
            JAPANESE -> "ゲームを開始"
        }

    val languageButton
        get() = when (language) {
            CHINESE -> "语言：${CHINESE.displayName}"
            ENGLISH -> "Language: ${ENGLISH.displayName}"
            JAPANESE -> "言語：${JAPANESE.displayName}"
        }

    val exitButton
        get() = when (language) {
            CHINESE -> "退出游戏"
            ENGLISH -> "Exit Game"
            JAPANESE -> "ゲーム終了"
        }
}