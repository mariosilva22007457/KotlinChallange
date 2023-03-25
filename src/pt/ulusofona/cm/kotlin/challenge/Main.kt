package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.Carro
import pt.ulusofona.cm.kotlin.challenge.models.Motor
import pt.ulusofona.cm.kotlin.challenge.models.Pessoa
import java.util.*

fun main() {

    val car = Carro("Mustang", Motor(550,2500))
    car.moverPara(100,1040)
    println(car)


}
    