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



}
