import scala.swing._
import java.awt.Color
import java.awt.Font


class UI extends MainFrame {
  def restrictHeight(s: Component) {
    s.maximumSize = new Dimension(Short.MaxValue, s.preferredSize.height)
  }
  
  title = "CService"
  preferredSize = new Dimension (700, 550)
  
  /*
  * Changing the color and font of the text shown
  */
  val header = new Label {
    text = "Hello! Welcome to CService"
    font = new Font ("Ariel",java.awt.Font.ITALIC,28)
    foreground = Color.BLUE 
  }
  val intro = new Label {
    text = "Lets get ready to volunteer!"
    font = new Font ("Ariel",java.awt.Font.PLAIN,22)
  }
  val des = new Label {
    text = "CService allows you to create and view volunteer opportunities!"
    font = new Font ("Ariel",java.awt.Font.PLAIN,16)
  }
  val startButton = new Button{
    text = "Let's get Started!"
    foreground = Color.LIGHT_GRAY
    background = Color.BLUE
  }
  
  val options = new Label {
    text = "Pick an option below!"
    font = new Font ("Ariel",java.awt.Font.PLAIN,22)
  }
  
  /*
   * Introduction Page
   * Gives some background to what CService is and what you can do on it
   * Made so that the user has the option of going back to a home page
   * User only has the option of getting started
   */
   contents = new BoxPanel(Orientation.Vertical) {
    background =  Color.WHITE 
    contents += Swing.VStrut(15)
    contents += header
    contents += Swing.VStrut(15)
    contents += intro
    contents += Swing.VStrut(15)
    contents += des
    contents += new BoxPanel(Orientation.Horizontal) {
      background = Color.WHITE
      contents += Swing.VStrut(10)
      contents += Swing.HStrut(10)
      contents += Button("Lets get started!") { homePage() }
      
    }
  }
  /*
   * Home Page
   * User has 2 options, create and opportunity or search for opportunities
   */
  def homePage(){
     contents = new BoxPanel(Orientation.Vertical) {
      background = Color.WHITE
      contents += new BoxPanel(Orientation.Horizontal) {
        background = Color.WHITE
        contents += Button("Create an Opportunity") { createOpportunity() }
        contents += Button("Look for Volunteer Opportunities") {volunteer()}
      }
    }
  }

  //Fields that allow the user to input data
  val nameField = new TextField { columns = 32 }
  val gender = new ComboBox(List("  ", "Female", "Male"))
  val Title = new ComboBox(List("  " ,"Counselor","Student", "Teacher", "Parent"))
  val city = new ComboBox(List("  " ,"Spokane", "Seattle", "Portland"))
  val state = new ComboBox(List("  ","OR", "WA"))
  
  //restricting the height of the various fields to fit appropriately on the screen
  restrictHeight(nameField)
  restrictHeight(gender)
  restrictHeight(city)
  restrictHeight(state)
  restrictHeight(Title)
  
  /*
  * Changing the color and font of the text shown
  */
  val nameT = new Label {
    text = "Name"
    font = new Font ("Ariel",java.awt.Font.PLAIN,20)
    foreground = Color.BLUE 
  }
  val genderT = new Label {
    text = "Gender"
    font = new Font ("Ariel",java.awt.Font.PLAIN,20)
    foreground = Color.BLUE 
  }
  val cityT = new Label {
    text = "City"
    font = new Font ("Ariel",java.awt.Font.PLAIN,20)
    foreground = Color.BLUE 
  }
  val stateT = new Label {
    text = "State"
    font = new Font ("Ariel",java.awt.Font.PLAIN,20)
    foreground = Color.BLUE 
  }
  val titleT = new Label {
    text = "Title"
    font = new Font ("Ariel",java.awt.Font.PLAIN,20)
    foreground = Color.BLUE 
  }
  
  /*
   * Volunteer Home page
   * User must fill in the appropriate data fields in order to best customize volunteer opportunities
   * User has the option of going back to the home page or searching for postings
   */
  def volunteer(){
    contents = new BoxPanel(Orientation.Vertical) {
      background =  Color.WHITE 
      contents += header
      contents += intro
      contents += new BoxPanel(Orientation.Horizontal) {
        background =  Color.WHITE 
        contents += nameT
        contents += Swing.HStrut(5)
        contents += nameField
      }
      contents += Swing.VStrut(5)
      contents += new BoxPanel(Orientation.Horizontal) {
        background =  Color.WHITE 
        contents += Swing.HStrut(5)
        contents += genderT
        contents += gender
      }
      contents += Swing.VStrut(5)
      contents += new BoxPanel(Orientation.Horizontal) {
        background =  Color.WHITE 
        contents += titleT
        contents += Swing.HStrut(10)
        contents += Title
      }
      contents += Swing.VStrut(5)
      contents += new BoxPanel(Orientation.Horizontal) {
        background =  Color.WHITE 
        contents += cityT
        contents += Swing.HStrut(10)
        contents += city
      }
      contents += Swing.VStrut(5)
      contents += new BoxPanel(Orientation.Horizontal) {
        background =  Color.WHITE 
        contents += stateT
        contents += Swing.HStrut(10)
        contents += state
      }
      contents += Swing.VStrut(5)
      contents += new BoxPanel(Orientation.Horizontal) {
        background =  Color.WHITE 
        contents += Swing.HGlue
        contents += Button("Search Postings") { searchPosts() }
        contents += Button("Back") {homePage() }
      }
      for (e <- contents)
        e.xLayoutAlignment = 0.0
        border = Swing.EmptyBorder(10, 10, 10, 10)
    }
  }
  
  /*
  * Changing the color and font of the text shown
  */
  val spIntro1 = new Label {
    text = "Hello,"
    font = new Font ("Ariel",java.awt.Font.ITALIC,22)
    foreground = Color.BLUE 
  }
  val spIntro2 = new Label {
    text = "You can search vounteer postings by Title or by Sponsor"
    font = new Font ("Ariel",java.awt.Font.PLAIN,20)
    foreground = Color.BLUE 
  }
  
  /*
  * Customized home page for volunteer postings
  * User gets the option of searching new postings or all postings and going back one level, to the volunteer home page
  */
  def searchPosts() {
    val nameIntro = new Label( nameField.text) 
    contents = new BoxPanel(Orientation.Vertical) {
      background =  Color.WHITE 
      contents += spIntro1
      contents += nameIntro
      contents += spIntro2
      contents += Swing.HStrut(10)
      contents += new BoxPanel(Orientation.Horizontal) {
        background =  Color.WHITE 
        contents += Button ("Positions") {postsByPosition()}
        contents += Swing.HStrut(10)
      }
      contents += new BoxPanel(Orientation.Horizontal) {
        background =  Color.WHITE 
       contents += Button ("Sponsors") {postsBySponsor()}
        contents += Swing.HStrut(10)
      }/*
      contents += new BoxPanel(Orientation.Horizontal) {
        background =  Color.WHITE 
        contents += Button ("All postings") {postsBySponsor()}
        contents += Swing.HStrut(10)
      }*/
      contents += new BoxPanel(Orientation.Horizontal) {
        background =  Color.WHITE 
        contents += Button("Back") {homePage()}
        contents += Swing.HStrut(10)
      }
    }
  }
  
  /*
  * Changing the color and font of the text shown
  */
  val creatingOpp = new Label {
    text = "Thanks for adding a volunteer opportunity, it has been saved to our database!"
    font = new Font ("Ariel",java.awt.Font.ITALIC,16)
    foreground = Color.BLUE 
  }
  val info1 = new Label{
    text = "You can choose to look for volunteer opportunites or go back to the home page."
    font = new Font ("Ariel",java.awt.Font.PLAIN,16)
    foreground = Color.BLUE 
  }
  /*
   * Confirmation page that the new volunteer opportunity has been created and saved
   */
  def postVOCreation() {
    val nameIntro = new Label( nameField.text) 
    contents = new BoxPanel(Orientation.Vertical) {
      background =  Color.WHITE 
      contents += creatingOpp
      contents += Swing.HStrut(10)
      contents += info1
      contents += Swing.HStrut(10)
      contents += new BoxPanel(Orientation.Horizontal) {
        background =  Color.WHITE 
        contents += Button ("Positions") {postsByPosition()}
        contents += Swing.HStrut(10)
      }
      contents += new BoxPanel(Orientation.Horizontal) {
        background =  Color.WHITE 
       contents += Button ("Sponsors") {postsBySponsor()}
        contents += Swing.HStrut(10)
      }
      contents += new BoxPanel(Orientation.Horizontal) {
        background =  Color.WHITE 
        contents += Button("Back") {homePage()}
        contents += Swing.HStrut(10)
      }
    }
  }
  
  /*
  * Changing the color and font of the text shown
  */
  val allPIntro = new Label {
    text = "These are the volunteer positions"
    font = new Font ("Ariel",java.awt.Font.ITALIC,22)
    foreground = Color.BLUE 
  }
 
  /*
  * New Posts page
  * User gets the options of viewing postings that were recently added and the option of going back one level, to the customized home page for postings
  */
  def postsByPosition(){
    contents = new BoxPanel (Orientation.Vertical){
      val newOpportunity: volunteerOpportunity = new volunteerOpportunity()
      background =  Color.WHITE 
      contents += allPIntro
      contents += Swing.VStrut(5)
      var getPositions: volunteerOpportunity = new volunteerOpportunity()
      var maxId:Int = getPositions.getMaxID
      var a = 1
      for( a <- 1 to maxId){
        var sponsor:String = getPositions.getPosition(a) 
        contents += new BoxPanel(Orientation.Vertical) {
          background =  Color.WHITE 
           contents += Swing.VStrut(2)
           contents += Swing.HGlue
           contents += Button(sponsor){printInfo(a)}
        }
        if(a == maxId)
           contents += new BoxPanel(Orientation.Horizontal) {
          background =  Color.WHITE 
            contents += Swing.HStrut(2)
            contents += Swing.HGlue
            contents += Button("Back") {searchPosts() }
        }
        else
          null
      }
    }
 }
 
  /*
  * Changing the color and font of the text shown
  */
  val allSIntro = new Label {
    text = "These are the sponsors looking for volunteers"
    font = new Font ("Ariel",java.awt.Font.ITALIC,22)
    foreground = Color.BLUE 
  }
  
  /*
   * All volunteer postings page
   * User gets the options of viewing all postings added to CServiece and the option of back one level, to the customized home page for postings
   */
  def postsBySponsor(){
    contents = new BoxPanel (Orientation.Vertical){
      val newOpportunity: volunteerOpportunity = new volunteerOpportunity()
      background =  Color.WHITE 
      contents += allSIntro
      contents += Swing.VStrut(5)
      var getSponsors: volunteerOpportunity = new volunteerOpportunity()
      var maxId:Int = getSponsors.getMaxID
      print(maxId)
      var a = 1
      for( a <- 1 to maxId){
        var sponsor:String = getSponsors.getSponsor(a) 
        contents += new BoxPanel(Orientation.Vertical) {
           background =  Color.WHITE 
           contents += Swing.VStrut(2)
           contents += Swing.HGlue
           contents += Button(sponsor){printInfo(a)}
        }
        if(a == maxId)
           contents += new BoxPanel(Orientation.Horizontal) {
           background =  Color.WHITE 
            contents += Swing.HStrut(2)
            contents += Swing.HGlue
            contents += Button("Back") {searchPosts() }
        }
      }
    }
 }
  
 /*
  * Changing the color and font of the text shown
  */
  val postInfoIntro = new Label {
    text = "Here are the details for your volunteer opporunity!"
    font = new Font ("Ariel",java.awt.Font.ITALIC,20)
    foreground = Color.BLUE 
  }
  val sponsorD = new Label {
    text = "Sponsor: "
    font = new Font ("Ariel",java.awt.Font.PLAIN,18)
    foreground = Color.BLUE 
  }
  val positionD = new Label {
    text = "Position: "
    font = new Font ("Ariel",java.awt.Font.PLAIN,18)
    foreground = Color.BLUE 
  }
  val descriptionD = new Label {
    text = "Description: "
    font = new Font ("Ariel",java.awt.Font.PLAIN,18)
    foreground = Color.BLUE 
  }
  val locationD = new Label {
    text = "Location: "
    font = new Font ("Ariel",java.awt.Font.PLAIN,18)
    foreground = Color.BLUE 
  }
  val datesD = new Label {
    text = "Dates: "
    font = new Font ("Ariel",java.awt.Font.PLAIN,18)
    foreground = Color.BLUE 
  }

  /*
   * Getting information about a certain volunteer post from our database and then displayin it to our screen
   */
   def printInfo(id: Int){
     background = Color.WHITE
     var opportunity: volunteerOpportunity = new volunteerOpportunity()
     val allPIntro = new Label("Here are the details for your volunteer opporunity!")
     val sponsor = new Label(opportunity.getSponsor(id))
     val position = new Label(opportunity.getPosition(id))
     val description = new Label( opportunity.getDescription(id))
     val Location = new Label(opportunity.getLocation(id))
     val dates = new Label( opportunity.getDate(id))
     
     contents = new BoxPanel (Orientation.Vertical){
       background =  Color.WHITE
      contents += postInfoIntro
      contents += Swing.VStrut(10)
      contents += sponsorD
      contents += sponsor
      contents += Swing.VStrut(10)
      contents += positionD
      contents += position
      contents += Swing.VStrut(10)
      contents += descriptionD
      contents += description
      contents += Swing.VStrut(10)
      contents += locationD
      contents += Location
      contents += Swing.VStrut(10)
      contents += datesD
      contents += dates
      
      contents += Swing.VStrut(5)
      
      contents += new BoxPanel(Orientation.Horizontal) {
        background =  Color.WHITE
        contents += Swing.HGlue
        contents += Button("Back") {postsBySponsor() }
      }
     }  
   }
  
  //Fields that allow the user to create a volunteer opportunity
  val sponsor = new TextField { columns = 32 }
  val position = new TextField { columns = 32 }
  val description = new TextField { columns = 32 }
  val Location = new TextField { columns = 32 }
  val dateBegin = new TextField { columns = 32 }
  val dateEnd = new TextField { columns = 32 }
  
  //restricting the height of the various fields to fit appropriately on the screen
  restrictHeight(position)
  restrictHeight(sponsor)
  restrictHeight(description)
  restrictHeight(Location)
  restrictHeight(dateBegin)
  restrictHeight(dateEnd)
  
  /*
  * Changing the color and font of the text shown
  */
  val positionT = new Label {
    text = "Position"
    font = new Font ("Ariel",java.awt.Font.PLAIN,20)
    foreground = Color.BLUE 
  }
  val sponsorT = new Label {
    text = "Sponsor"
    font = new Font ("Ariel",java.awt.Font.PLAIN,20)
    foreground = Color.BLUE 
  }
  val descriptionT = new Label {
    text = "Description"
    font = new Font ("Ariel",java.awt.Font.PLAIN,20)
    foreground = Color.BLUE 
  }
  val locationT = new Label {
    text = "Location"
    font = new Font ("Ariel",java.awt.Font.PLAIN,20)
    foreground = Color.BLUE 
  }
   val dateBeginT = new Label {
    text = "Begin Date"
    font = new Font ("Ariel",java.awt.Font.PLAIN,20)
    foreground = Color.BLUE 
  }
  val dateEndT = new Label {
    text = "End Date"
    font = new Font ("Ariel",java.awt.Font.PLAIN,20)
    foreground = Color.BLUE 
  }
  
   /*
   * Creating an opportunity page
   * Requires user to fill in various data fields in order to fill in the volunteer postings database
   * Field names must stay consistent/same to the ones used in DBconnector.scala and volunteerOpportunity.scala
   */
  def createOpportunity(){
   contents = new BoxPanel(Orientation.Vertical) {
     background =  Color.WHITE
     contents += Swing.VStrut(5)
     contents += new BoxPanel(Orientation.Horizontal) {
       background =  Color.WHITE
      contents += positionT
      contents += Swing.HStrut(10)
      contents += position
     }
     contents += Swing.VStrut(5)
     contents += new BoxPanel(Orientation.Horizontal) {
       background =  Color.WHITE
      contents += sponsorT
      contents += Swing.HStrut(10)
      contents += sponsor
     }
     contents += Swing.VStrut(5)
     contents += new BoxPanel(Orientation.Horizontal) {
       background =  Color.WHITE
      contents += descriptionT
      contents += Swing.HStrut(10)
      contents += description
     }
     contents += Swing.VStrut(5)
     contents += new BoxPanel(Orientation.Horizontal) {
       background =  Color.WHITE
      contents += locationT
      contents += Swing.HStrut(10)
      contents += Location
     }
     contents += Swing.VStrut(5)
     contents += new BoxPanel(Orientation.Horizontal) {
       background =  Color.WHITE
      contents += dateBeginT
      contents += Swing.HStrut(10)
      contents += dateBegin
     }
     contents += Swing.VStrut(5)
     contents += new BoxPanel(Orientation.Horizontal) {
       background =  Color.WHITE
      contents += dateEndT
      contents += Swing.HStrut(10)
      contents += dateEnd
     }
     contents += Swing.VStrut(5)
     contents += new BoxPanel(Orientation.Horizontal) {
       background =  Color.WHITE
      contents += Swing.HGlue
      contents += Button("Back") {homePage() }
      contents += Button("Submit Posting") {var newOpportunity: volunteerOpportunity = new volunteerOpportunity();
      newOpportunity.createOpportunity(sponsor.text, position.text, description.text, Location.text, dateBegin.text, dateEnd.text);
      postVOCreation()}
     }
     
     for (e <- contents){
      e.xLayoutAlignment = 0.5
      border = Swing.EmptyBorder(10, 10, 10, 10)
    }
   }
  }
}

object CService {
  def main(args: Array[String]) {
    val ui = new UI
    ui.visible = true
  }
}
