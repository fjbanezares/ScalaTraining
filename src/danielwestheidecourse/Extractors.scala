package danielwestheidecourse

/**
  * Created by Usuario on 15/11/2018.
  */
object Extractors {

//Case class auomatically creates a companion object with an apply to create new instances
  // and unapply
  case class User(firstName: String, lastName: String, score: Int)
  def advance(xs: List[User]) = xs match {
    case User(_, _, score1) :: User(_, _, score2) :: _ => score1 - score2
    case _ => 0
  }


  // In general we need to create the companion object and the Extractor
  // def unapply(object: S): Option[T]
  // pepe

  trait User2 {
    def name: String
  }
  class FreeUser(val name: String) extends User2
  class PremiumUser(val name: String) extends User2

  object FreeUser {
    def unapply(user: FreeUser): Option[String] = Some(user.name)
  }
  object PremiumUser {
    def unapply(user: PremiumUser): Option[String] = Some(user.name)
  }

//def unapply(object: S): Option[(T1, ..., Tn)]
  trait User {
    def name: String
    def score: Int
  }
  class FreeUser(val name: String, val score: Int, val upgradeProbability: Double)
    extends User
  class PremiumUser(val name: String, val score: Int) extends User

  def main(args: Array[String]): Unit = {

    val listUsers: List[User] = List(User("Javi", "Banez", 15), User("Manueal", "Pamdo", 22))
    println(advance(listUsers))

    println(FreeUser.unapply(new FreeUser("Daniel")))

    val user: User2 = new PremiumUser("Daniel")
    println(
      user match {
      case FreeUser(name) => "Hello " + name
      case PremiumUser(name) => "Welcome back, dear " + name
    }
    )


  }
}
