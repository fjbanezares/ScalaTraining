package hackerRank

import com.google.common.math.BigIntegerMath
import scala.collection.mutable

object SherlockAndAnagrams extends App{

  def sherlockAndAnagrams(s: String): Int = {
    val sylabs = mutable.Map[mutable.Map[Char, Int],Int]()
    for(i <- s.indices){
      var j = i+1
      while(j <= s.length){
        val substFirma = calculateFirma(s.substring(i,j))
        if(sylabs.keySet.contains(substFirma)){
          sylabs(substFirma) += 1
        }
        else{
          sylabs += substFirma -> 1
        }
        j+=1
      }
    }
    var counter = 0
    for((key,value) <- sylabs if value >= 2 ){
      counter = counter + BigIntegerMath.binomial(value,2).intValue()
    }
  counter
  }

  def calculateFirma(word: String): mutable.Map[Char, Int] ={
    val firma = mutable.Map[Char, Int]()
    for(c <- word){
      if(firma.keySet.contains(c)){
        firma(c) += 1
      }
      else firma += c -> 1
    }
    firma
  }
}