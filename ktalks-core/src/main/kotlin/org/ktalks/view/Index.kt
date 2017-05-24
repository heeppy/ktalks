package org.ktalks.view

import kotlinx.html.*
import kotlinx.html.stream.*

/**
 * Index page template
 * @author mlshv
 */
fun index(): String {
    return createHTML().html {
        body {
            p {
                +"Hello, community!"
            }
        }
    }
}