package soc;

trait GUIImplicits {
  implicit def MI12List(a: MI1) : scala.List[MI1] = { a :: Nil }
}