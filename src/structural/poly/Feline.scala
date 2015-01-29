package structural.poly

sealed trait Feline  { //represents everything that is cattish
  def dinner:Food //this isnt defined, it;s a placeholder, so we must put dinner in each of the final
  //classes below
  
  //lion panther tiger cat
  
  /*
   * 1. POLYMORPHIC DISPATCH --IF THE TYPE IS THIS, THEN DO THAT.
   * 2. PATTERN MATCHING 
   * BOTH 1,2 WORK WITHIN THE EXITING CLASSES. OBJ ORIENTED WORLD
   * 
   * EXTERNAL OBJECTS CAN BE USED WHEN REFERENCING THINGS THAT ARE NOT PART F THE HIERARCHY, I.E
   * HERE WE ARE TALKING ABOUT DINNER, AND SAY WE WANTED TO TALK ABOUT WHO COOKED IT, IF THAT'S 
   * APPLICATBLE THEN USE AN EXTERNAL OBJECT/
   * FUNCTIONAL PROGRAMMING WORLD
   * 
   * OO -> TO ADD A NEW METHODS YOU HAVE TO CHANGE EXISTING CODE, TO ADD NEW DATA YOU CAN LEAVE THE 
   * CODE UNCHANGED
   * 
   * FP-> ADD A NEW METHODS YOU CAN LEAVE THE EXISTING CODE UNCHANGED. WHEN YOU ADD NEW DATA YOU HAVE TO 
   * CHANGE THE EXISTING CODE.
   * 
   */
  
  
final case class Lion () extends Feline //have the  () when it's a case class 
    {
    def dinner:Food = Antelope
    }
  
final case class Panther () extends Feline
    {
    def dinner:Food = TigerStuff
    }

final case class Tiger () extends Feline 
    {
    def dinner:Food = TigerStuff
    }

final case class Cat (favFood:String) extends Feline 
    {
    def dinner:Food = CatFood(favFood)
    }
  

}

sealed trait Food 
  final object Antelope extends Food
  final object TigerStuff extends Food
  final case class CatFood (food:String) extends Food
  
