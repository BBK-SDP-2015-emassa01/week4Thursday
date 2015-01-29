package sealedTraits

sealed trait DivisionResult 
  /* divide can be anything so we can create an object, as we will only create one of it.
   * divide (1,2) => Finite(0)
   * divide (2,1) => Finite(2)
   * divide (1,0) => Infinite
   */
//our 2 results are exhaustive 'finite/infinite'

final case class Finite(value:Int) extends DivisionResult
//DivisionResult acts as an abstraction of the subtypes, it's not an object as there are many results Finite.
  
final case object Infinite extends DivisionResult

object divide {
  
def apply(numerator:Int, denominator:Int) = 
  if (denominator ==0 ) Infinite else Finite (numerator/denominator)
}

object test extends App {
  divide(1,0) match {
    case Finite(value) => s"it's finite: s{value}"
    case Infinite => s"it's infinite" //covered both cases, try and model things this way.
    /*
     * we only needed one 'infinite' so we just used an object, otherwise we can use a class
     * It all has to appear in the same file.
     */
  }
}