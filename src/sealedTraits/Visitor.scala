package sealedTraits

import java.util.Date

sealed trait Visitor { // we will see what 'sealed' means below
  def id:String
  def createdAt: Date
  def age:Long = new Date().getTime - createdAt.getTime // 3fields
  /*
   * traits are sup-ed up interfaces and have code in them, they're like java8 interfaces
   */
}//gives us apply, unapply, hashcode, equals, getter and setters

//anonymous is a type of visitor
//case classes do alot o the boiler plate code, generating fields and all that
case class Anonymous(id:String, createdAt:Date) extends Visitor
case class User(id:String, email:String, createdAt:Date) extends Visitor

//private in java means accessible by class, but in scala, means FOR THAT INSTANCE.
//protected in java means subclasses and below, and package access, but in scala means subclasses.
//package in scala means package.

/*
 * If a visitor can only have 2 subclasses of it, you want to inforce that you can use a type of pattern matching
 * ...there is strong typed in scala. If you use 'sealed' it means that you only want to allow these case class
 * but you can create subclasses of these...!
 * how is it useful?
 * Well suppose you want to create an object
 * --it does tell you that its not exhaustive... buuuuuuuuut you have to check in REPL.
 */

object Thing extends App {
  
  def missing (v:Visitor) =
    v match {
    case User(_,_,_) => "Ah a user"
  }
  //you cannot rely on the IDE to do your work for you, you must check in the REPL.
}

