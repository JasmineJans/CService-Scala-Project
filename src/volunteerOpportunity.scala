class volunteerOpportunity(){
  
  var id: Int = 0
  var sponsor: String = ""
  var position: String = ""
  var beginDate: String = ""
  var endDate: String = ""
  var location: String = ""
  var description:String = ""
  var database: DBConnector = new DBConnector()
  
  def createOpportunity (sponsor: String, position: String, description: String, beginDate: String, endDate: String, location: String): Unit = database.createOpportunity(sponsor, position, description, beginDate, endDate, location)
  def editDescription(d: String, id: Int) : Unit = {description = d; database.setDescription(d, id)}
  def setBeginDate(d: String, id: Int) : Unit = {database.setBeginDate(d,id); beginDate = d}
  def setEndDate(d: String, id: Int) : Unit = {database.setEndDate(d,id); endDate = d}
  def setPosition (p: String, id: Int) : Unit = {database.setPosition(p,id); position = p}
  def setSponsor (s:String, id: Int) : Unit = {database.setSponsor(s,id); sponsor = s}
  def setLocation (l: String, id: Int) : Unit = {database.setLocation(l,id); location = l}
  
  def deleteEntry (id: Int) : Unit = database.deleteOpportunity(id)
  
  def getDescription (id: Int): String = database.getDescription(id)
  def getDate (id: Int): String  = database.getDates(id)
  def getPosition (id: Int): String = database.getPosition(id)
  def getSponsor (id: Int): String = database.getSponsor(id)
  def getLocation (id: Int): String = database.getLocation(id)
  def getMaxID: Int = database.getMaxID
  
  def printInfo1 (id: Int): String = {"Sponsor: " + getSponsor(id) + " Description: " + getDescription(id) + " Location: " + getLocation(id) + "Dates: " + getDate(id) + " Position: " + getPosition(id)}
}