
//import scala.swing._

class user (var n: String, var g:String, var s: String, var c: String, var t: String){
  var name: String = n
  var gender: String = g
  var state: String = s
  var city: String = c
  var title: String = t
  
  def setName(n: String) : Unit = name = n
  def setGender(g: String): Unit = gender = g
  def setState(s: String): Unit = state = s
  def setCity(c: String): Unit = city = c
  def setTitle(t: String): Unit = title = t
  
  def getName = name
  def getGender = gender 
  def getState = state
  def getCity = city
  def getTitle = title
}

object test1{
  def main(args: Array[String]){
  val user1 = new user("george", "boy", "nevada", "reno", "student")
  println(user1.getName)
  println(user1.getState)
  }
}
