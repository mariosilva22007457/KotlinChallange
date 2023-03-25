package pt.ulusofona.cm.kotlin.challenge.models
import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.util.*

 class Pessoa(var nome: String, var dataDeNascimento: Date) : Movimentavel {
     val veiculos = mutableListOf<Veiculo>()
     lateinit var carta: Carta

     var posicao = Posicao(0, 0)

     override fun moverPara(x: Int, y: Int) {
      if(posicao.x.equals(x) && posicao.y.equals(y)){
          throw AlterarPosicaoException("Já se encontra na posição que pretende ir")
      }

         posicao.alterarPosicaoPara(x,y)
     }

     fun comprarVeiculo(veiculo: Veiculo){
         veiculos.add(veiculo)
         veiculos.last().dataDeAquisicao = Date()
     }

     fun pesquisarVeiculo(identificador: String): Veiculo {
         return veiculos.find { it.identificador == identificador }
             ?: throw VeiculoNaoEncontradoException("O veiculo com o identificador: $identificador não existe")
     }


     fun moverVeiculoPara(identificador: String, x: Int,y: Int){
         val veiculo = pesquisarVeiculo(identificador)

         require(!veiculo.requerCarta() || temCarta()) {
             "${this.nome} não tem carta para conduzir o veículo indicado"
         }

         veiculo.moverPara(x, y)

     }

     fun temCarta(): Boolean{
         if(this::carta.isInitialized && carta is Carta)
         {
             return true
         }

         return false


     }



     fun underAge(): Boolean{
         val today = Date().time
         val birthdate = this.dataDeNascimento.time
         val ageInMilliseconds = today - birthdate
         val ageInYears = ageInMilliseconds / (1000 * 60 * 60 * 24 * 365.25)
         return ageInYears < 18

     }

     fun venderVeiculo(identificador: String,compradorDoCarro: Pessoa){
         val veiculo = pesquisarVeiculo(identificador)

         compradorDoCarro.comprarVeiculo(veiculo)

         compradorDoCarro.veiculos.last().dataDeAquisicao = Date()

         veiculos.remove(veiculo)

     }

     fun tirarCarta(){

         if(underAge()){
             throw MenorDeIdadeException("$nome não tem idade para tirar a carta")
         }

             this.carta = Carta()


     }


     override fun toString(): String {
         return "Pessoa | $nome | ${SimpleDateFormat("dd-MM-yyyy").format(dataDeNascimento)} | Posicao | x:${posicao.x} | y:${posicao.y}"
     }



 }