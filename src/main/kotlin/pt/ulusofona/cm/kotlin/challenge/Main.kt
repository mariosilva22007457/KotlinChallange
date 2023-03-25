package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.Carro
import pt.ulusofona.cm.kotlin.challenge.models.Motor
import pt.ulusofona.cm.kotlin.challenge.models.Pessoa
import java.util.*

fun main() {

    val carro = Carro("Mercedes", Motor(150,3000))
    carro.moverPara(50,100)
    println(carro)


}
    