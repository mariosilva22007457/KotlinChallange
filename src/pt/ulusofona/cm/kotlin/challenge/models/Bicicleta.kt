package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import java.util.*

 class Bicicleta(identificador:String) : Veiculo(identificador) {
    override var dataDeAquisicao: Date = Date()


    override fun requerCarta(): Boolean {
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        if(posicao.x.equals(x) && posicao.y.equals(y)){
            throw AlterarPosicaoException("O veiculo já se encontra na posição que pretende ir")
        }

        posicao.alterarPosicaoPara(x,y)
    }

}