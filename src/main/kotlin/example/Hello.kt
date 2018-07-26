package example

import javafx.scene.paint.Color
import tornadofx.*

class HelloWorld : View() {
    override val root = vbox {
        hbox {
            addClass(HelloWorldStyle.myBorder)
            label("border set by type-safe css")
        }
        hbox {
            style = """
                -fx-border-color: blue;
                -fx-border-width: 4;
                -fx-padding: 10px;
            """
            label("border set by style")
        }
        hbox {
            stylesheets.add("hello.css")
            addClass("mypane")
            label("border set type css file")
        }
    }
}

class HelloWorldStyle : Stylesheet() {
    companion object {
        val myBorder by cssclass()
    }

    init {
        root {
            prefWidth = 400.px
            prefHeight = 400.px
        }

        myBorder {
            borderWidth += box(5.px)
            borderColor += box(Color.RED)
            borderInsets += box(10.px)
            borderRadius += box(30.px)
        }
    }
}

class HelloWorldApp : App(HelloWorld::class, HelloWorldStyle::class)

fun main(args: Array<String>) {
    launch<HelloWorldApp>()
}