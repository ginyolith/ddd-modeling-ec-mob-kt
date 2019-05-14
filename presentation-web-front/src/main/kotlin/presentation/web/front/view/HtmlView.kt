package presentation.web.front.view

import io.ktor.application.ApplicationCall
import io.ktor.html.respondHtml
import kotlinx.html.HTML

internal abstract class HtmlView {
    protected abstract fun html(): HTML.() -> Unit

    suspend fun render(call: ApplicationCall) {
        call.respondHtml(block = html())
    }
}