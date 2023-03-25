package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.util.*

abstract class Veiculo(open var identificador: String) : Movimentavel{
    var posicao = Posicao(0,0)
    abstract var dataDeAquisicao : Date


    abstract fun requerCarta():Boolean

    override fun toString(): String {
        return "${this.javaClass.simpleName} | $identificador | ${SimpleDateFormat("dd-MM-yyyy").format(dataDeAquisicao)} | Posicao | x:${posicao.x} | y:${posicao.y}"
    }



}

