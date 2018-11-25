package hackerrank

import java.io.{PrintWriter, _}
import java.math._
import java.security._
import java.text._

import scala.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

import scala.collection.mutable.ListBuffer

/**
  * Created by Javi
  * The first line contains an integer , the number of queries.
Each of the next  lines contains a string  to analyze.
  */

object SherlockAndAnagrams {


  def firma(palabra: String): scala.collection.mutable.Map[Char,Int] = {

    val pepe: scala.collection.mutable.Map[Char, Int] = scala.collection.mutable.Map()

    for( caracter <- palabra){
      if (pepe.keySet.contains(caracter)) pepe(caracter) += 1
      else pepe += caracter -> 1
    }
    pepe
  }


  // Complete the sherlockAndAnagrams function below.(
  def sherlockAndAnagrams(s: String): Int = {

    // Map que recoge todos los substrings de cada tamaño
    val mapSubstringsa: scala.collection.mutable.Map[Int, List[(String, String)]] = scala.collection.mutable.Map[Int, List[(String, String)]]()
    val resultado: ListBuffer[((String,String),(String,String))] = ListBuffer()

    // recorro las posiciones del array y genero los substrings de distintos tamaños
    val longitudArray = s.length
    for(substringSize <- 1 until longitudArray){
      for(startCharacter <- 0 to (longitudArray - substringSize)){
        if (mapSubstringsa.keySet.contains(substringSize)) {

          mapSubstringsa(substringSize) = (s.substring(startCharacter,startCharacter + substringSize),startCharacter.toString+(startCharacter+substringSize-1).toString)::mapSubstringsa(substringSize)

        } else mapSubstringsa += substringSize -> List((s.substring(startCharacter,startCharacter + substringSize),(startCharacter.toString+((startCharacter+substringSize-1).toString))))
        }
    }

    for(caso <- mapSubstringsa){
      for (elementoLista <- 0 until caso._2.length){
        for (elementoLista2 <- (elementoLista +1) until caso._2.length){
          val valorAFirmar1 = caso._2(elementoLista)._1
          val firma1 = firma(valorAFirmar1)
          val valorAFirmar2 = caso._2(elementoLista2)._1
          val firma2 = firma(valorAFirmar2)

          if(firma1 == firma2) {
            val elemento:((String,String),(String,String)) = (caso._2(elementoLista), caso._2(elementoLista2))
            resultado += elemento
          }
        }
      }

    }

    // Miro si se trata de esttucturas anagrámicas comparando las firmas

    // vo-y devolviendo las parejitas que macheen en una lista

    // devuelvo la longitud de la lista final



println(resultado)
resultado.length
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

  //  val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val s = stdin.readLine

      val result = sherlockAndAnagrams(s)

      println(result)
    }

  }

}
