package top.mioyi.client

import com.raylib.Raylib.*
import top.mioyi.utils.*
import kotlin.io.path.*


object FontResource : AutoCloseable {
    private const val PATH = "fonts/simhei.ttf"
    private val type = "." + Path(PATH).extension
    private val data = loadBytes(PATH)!!
    private val fonts = mutableMapOf<String, Font>()

    fun getFont(text: String) =
        fonts.getOrPut(text) {
            val codepoints = loadCodepoints(text)

            LoadFontFromMemory(
                type,
                data, data.size,
                64,
                codepoints, codepoints.size * 2
            )
        }


    fun removeFont(text: String) {
        val font = fonts.remove(text)
        if (font != null) {
            UnloadFont(font)
        }
    }

    override fun close() {
        fonts.values.forEach(::UnloadFont)
    }
}