package danielwestheidecourse

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object magicArray {
  // Complete the formingMagicSquare function below.
  def formingMagicSquare(s: Array[Array[Int]]): Int = {

    //funcion calculo costes

    //funcion isMagic

  // formingMagicSquareRec(s,0).get()
    0
  }

  def isMagic(s:Array[Array[Int]]) : Boolean = ???
  def addToPosition(s:Array[Array[Int]],num: Int, posX: Int, posY: Int ): Array[Array[Int]] = {
    val clonado = s.clone()
   // val filaEnLizaUpdate = clonado(posX).update(posY,s(posX,posY+num))
    clonado
  }
  //def formingMagicSquareRec(s:Array[Array[Int]], coste:Int): List[Array[Array[Int]],Int]

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s = Array.ofDim[Int](3, 3)

    for (i <- 0 until 3) {
      s(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = formingMagicSquare(s)

    printWriter.println(result)

    printWriter.close()
  }

}

