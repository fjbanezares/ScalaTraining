def firma(palabra: String): scala.collection.mutable.Map[Char,Int] = {

  val pepe: scala.collection.mutable.Map[Char, Int] = scala.collection.mutable.Map()()

  for( caracter <- palabra){
    if (pepe.keySet.contains(caracter)) pepe(caracter) += 1
    else pepe += caracter -> 1
  }
  pepe
}

firma("perro")