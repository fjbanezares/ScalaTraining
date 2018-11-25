
val pepe = 1 until 3
println(pepe.toList)

val listaStrings: List[(String, String )] = List()

("po","po")::listaStrings

val mapSubstringsa: scala.collection.mutable.Map[Int, List[(String, String)]] = scala.collection.mutable.Map[Int, List[(String, String)]]()
val mapSubstringsb: scala.collection.mutable.Map[Int, List[(String, String)]] = scala.collection.mutable.Map[Int, List[(String, String)]]()

mapSubstringsa += 2->List(("pe","pe"))
mapSubstringsa += 1->List(("pe","pe"))
mapSubstringsa(1) = ("po","po")::mapSubstringsa(1)


mapSubstringsb += 1->List(("pe","pe"))
mapSubstringsb(1) = ("po","po")::mapSubstringsb(1)
mapSubstringsb += 2->List(("pe","pe"))

mapSubstringsa == mapSubstringsb

List(1,2,3) == List(1,2,3)

"abc".substring(0,2)