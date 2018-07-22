package example

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.paint.Color
import tornadofx.*

class HelloWorld : View() {
    override val root = hbox {
        addClass(HelloWorldStyle.myBorder)
        label("Hello world!")
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
            alignment = Pos.CENTER
            fontSize = 50.px
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