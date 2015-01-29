package intList

sealed trait IntList {
  
  /*
   * 1 -> 2-> 3-> 4->EndOfList
   * or
   * (1, (2, (3, EndOfList)))
   * where each item is the current + the next one, recursive
   * 
   */
  
  //so we always have an end of list, which is a IntList.
  
  final case object EndOfList extends IntList //one of these
  final case class Pair(head:Int, tail:IntList) extends IntList 
  //case classes have a toString()
  
  //so we can type stuff like
  
  /*
   * EndOfList
   * Pair (1, EndOfList)
   * Pair (1, Pair(2, Pair(3, Pair(4, EndOfList))))
   */
  
  //How do we traverse this list? Let's use recursion.

  object Thing extends App{
    
    def sum(list:IntList) :Int =
    //can call the list OO way (polymorphism) and via pattern matching, which is more functional.
    list match {
      case EndOfList => 0
      case Pair(head, tail) =>head + sum(tail) //recursion.
    } 
      
    val b = Pair (1, Pair(2, Pair(3, Pair(4, EndOfList))))
    println(b)
    println(sum(b))
  }
  
      
   /*
   * termination condition is EndOfList
   * Scala does so much more typechecking, so its 10 x slower than Java, there is 
   * not a delay after the code has been built, it's fast!
   */

}
