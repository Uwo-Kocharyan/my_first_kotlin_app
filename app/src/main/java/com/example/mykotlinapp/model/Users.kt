package com.example.mykotlinapp.model

data class Users (
    var name: String? = null,
)



//class Car( //add private constructor if necessary
//        val model: String?,
//        val year: Int
//) {
//
//    private constructor(builder: Builder) : this(builder.model, builder.year)
//
//    class Builder {
//        var model: String? = null
//            private set
//
//        var year: Int = 0
//            private set
//
//        fun model(model: String) = apply { this.model = model }
//
//        fun year(year: Int) = apply { this.year = year }
//
//        fun build() = Car(this)
//    }
//}


class Car(
    val model: String?,
    val color: String?,
    val type: String?) {

    data class Builder(
        var model: String? = null,
        var color: String? = null,
        var type: String? = null) {

        fun model(model: String) = apply { this.model = model }
        fun color(color: String) = apply { this.color = color }
        fun type(type: String) = apply { this.type = type }
        fun build() = Car(model, color, type)
    }
}

val car = Car.Builder()
    .model("Ford Focus")
    .color("Black")
    .type("Type")
    .build()