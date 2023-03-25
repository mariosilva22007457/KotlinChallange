package pt.ulusofona.cm.kotlin.challenge.models
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

 class Motor(var cavalos: Int, var cilindrada: Int) : Ligavel {
    var on: Boolean = false
     var off : Boolean = false



    override fun ligar() {
        if(on){
            throw  VeiculoLigadoException("O veiculo já se encontra ligado")
        }

        on = true
        off = false

    }


     override fun desligar() {
         if(off){
             throw VeiculoDesligadoException("O veiculo já encontra desligado")
         }
         off = true
         on = true
     }

     override fun estaLigado(): Boolean {
        return on


     }

     override fun toString(): String {
         return "Motor | $cavalos | $cilindrada"
     }


 }