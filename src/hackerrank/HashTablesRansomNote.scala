package hackerrank

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

/**
The first line contains two space-separated integers, m and n, the numbers of words in the magazine and the note
The second line contains m  space-separated strings, each magazine[i]
The third line contains  n space-separated strings, each note[i]
  */
object HashTablesRansomNote {





    // Complete the checkMagazine function below.
    def checkMagazine(magazine: Array[String], note: Array[String]) {
        val noteMap : scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map[String,Int]()
        val magazineMap : scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map()


      for (elem <- note) {
        if (noteMap.keySet.contains(elem)) noteMap(elem) += 1
        else noteMap += elem -> 1
      }

      for (elem <- magazine) {
        if (magazineMap.keySet.contains(elem)) magazineMap(elem) += 1
        else magazineMap += elem -> 1
      }

      def isAccomplished(magazineElems: scala.collection.mutable.Map[String, Int], noteElems: scala.collection.mutable.Map[String, Int]): Boolean  = {
        for ((elem,occurrencies) <- noteMap) {
          if (!(magazineElems.contains(elem) && occurrencies <= magazineElems(elem) )) return false
        }
        true
      }

      if (isAccomplished(magazineMap,noteMap)) println("yes") else println("no")
    }

    def main(args: Array[String]) {
      val stdin = scala.io.StdIn

      val mn = stdin.readLine.split(" ")


      val n = mn(1).trim.toInt

      val magazine = stdin.readLine.split(" ")

      val note = stdin.readLine.split(" ")
      checkMagazine(magazine, note)
    }



}
