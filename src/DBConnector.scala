import java.sql.{Connection,DriverManager}

class DBConnector extends App {
	var connection:Connection = _

def getSponsor(id: Int): String = {
		val url = "jdbc:mysql://ada.gonzaga.edu:3306/movieTheater_DB"
		val driver = "com.mysql.jdbc.Driver"
		val username = "jjans"
		val password = "jjans88607111"
		try {
			Class.forName(driver)
			if (connection == null)
				connection = DriverManager.getConnection(url, username, password)
			else
			  null
			val statement = connection.createStatement
			val rs = statement.executeQuery("SELECT sponsor FROM volunteerOpportunity" + " where volunteerOpportunity_id=" + id)
			while (rs.next){
		  val sponsor = rs.getString("sponsor")
			return sponsor
		  }
	  } catch {
				case e: Exception => e.printStackTrace
		}
			 // connection.close()
			  return ""
}
	
def getPosition(id:Int): String = {
		val url = "jdbc:mysql://ada.gonzaga.edu:3306/movieTheater_DB"
		val driver = "com.mysql.jdbc.Driver"
		val username = "jjans"
		val password = "jjans88607111"
		try {
			Class.forName(driver)
			if (connection == null)
				connection = DriverManager.getConnection(url, username, password)
		  else
		    null
		  val statement = connection.createStatement
		  val rs = statement.executeQuery("SELECT position FROM volunteerOpportunity" + " where volunteerOpportunity_id=" + id)
			while (rs.next){
			  val position = rs.getString("position")
			  return position
			}
	  } catch {
				case e: Exception => e.printStackTrace
		}
	    //connection.close()
	    return ""
}	

def getDescription(id: Int): String = {
		val url = "jdbc:mysql://ada.gonzaga.edu:3306/movieTheater_DB"
		val driver = "com.mysql.jdbc.Driver"
		val username = "jjans"
		val password = "jjans88607111"
		try {
			Class.forName(driver)
			if (connection == null)
				connection = DriverManager.getConnection(url, username, password)
			else
		    null
			val statement = connection.createStatement
			val rs = statement.executeQuery("SELECT description FROM volunteerOpportunity" + " where volunteerOpportunity_id=" + id)
			while (rs.next){
			  val description = rs.getString("description")
				return description
			}
	  } catch {
				case e: Exception => e.printStackTrace
		}
			  //connection.close()
			  return ""
}
def getLocation (id: Int): String = {
		val url = "jdbc:mysql://ada.gonzaga.edu:3306/movieTheater_DB"
		val driver = "com.mysql.jdbc.Driver"
		val username = "jjans"
		val password = "jjans88607111"
		try {
			Class.forName(driver)
			if (connection == null)
				connection = DriverManager.getConnection(url, username, password)
			else
		    null
			val statement = connection.createStatement
			val rs = statement.executeQuery("SELECT location FROM volunteerOpportunity" + " where volunteerOpportunity_id=" + id)
			while (rs.next){
				val location = rs.getString("location")
				return location
			}
	  } catch {
				case e: Exception => e.printStackTrace
		}
			  return ""
}

def getDates (id: Int): String = {
		val url = "jdbc:mysql://ada.gonzaga.edu:3306/movieTheater_DB"
		val driver = "com.mysql.jdbc.Driver"
		val username = "jjans"
		val password = "jjans88607111"

		try {
			Class.forName(driver)
			if (connection == null)
				connection = DriverManager.getConnection(url, username, password)
			else
		    null
			val statement = connection.createStatement
			val rs = statement.executeQuery("SELECT beginDate, endDate FROM volunteerOpportunity" + " where volunteerOpportunity_id=" + id)
			while (rs.next){
				val beginDate = rs.getString("beginDate")
				val endDate = rs.getString("endDate")
				return beginDate + "-" + endDate
			}
		} catch {
				case e: Exception => e.printStackTrace
		}
		return ""
}

def getMaxID: Int= {
		val url = "jdbc:mysql://ada.gonzaga.edu:3306/movieTheater_DB"
		val driver = "com.mysql.jdbc.Driver"
		val username = "jjans"
		val password = "jjans88607111"

		try {
			Class.forName(driver)
			if (connection == null)
				connection = DriverManager.getConnection(url, username, password)
			else
		    null
			val statement = connection.createStatement
			var maxId = 0
			statement.execute("SELECT MAX(volunteerOpportunity_id) FROM volunteerOpportunity")
			val results = statement.getResultSet()
			if (results.next() )
					maxId = results.getInt(1)
			else
			    maxId
			return maxId
		} catch {
				case e: Exception => e.printStackTrace
		}
		return 0
}

def createOpportunity(sponsor: String, position: String, description: String, location:String, dateBegin: String, dateEnd: String)  = {
		val url = "jdbc:mysql://ada.gonzaga.edu:3306/movieTheater_DB"
		val driver = "com.mysql.jdbc.Driver"
		val username = "jjans"
		val password = "jjans88607111"

		try {
			Class.forName(driver)
			if (connection == null)
				connection = DriverManager.getConnection(url, username, password)
			else
		    null
			var maxId = this.getMaxID + 1
			/*val statement1 = connection.createStatement()
			statement1.execute("SELECT MAX(volunteerOpportunity_id) FROM volunteerOpportunity")
			val results = statement1.getResultSet()
			if (results.next() )
					maxId = results.getInt(1)
			else 
			    maxId = 0
			maxId  = maxId + 1
			*/
			
			var query: String = "INSERT INTO volunteerOpportunity (`volunteerOpportunity_id`, `position`, `sponsor`, `description`, `location`, `beginDate`, `endDate`) " + "VALUES (?, ?, ?, ?, ?, ?, ?)"
			val statement = connection.prepareStatement(query)
			statement.setInt(1, maxId)
			statement.setString(2,position)
			statement.setString(3,sponsor)
			statement.setString(4,description)
			statement.setString(5,location)
			statement.setString(6,dateBegin)
			statement.setString(7,dateEnd)
			statement.execute()
		} catch {
				case e: Exception => e.printStackTrace
		}
}

def setPosition(position: String, id: Int)  = {
		val url = "jdbc:mysql://ada.gonzaga.edu:3306/movieTheater_DB"
		val driver = "com.mysql.jdbc.Driver"
		val username = "jjans"
		val password = "jjans88607111"

		try {
			Class.forName(driver)
			if (connection == null)
				connection = DriverManager.getConnection(url, username, password)
			else
		    null
			var query: String = "UPDATE volunteerOpportunity SET position = ?" + " where volunteerOpportunity_id=" + id
			val statement = connection.prepareStatement(query)
			statement.setString(2,position)
			statement.execute()
		} catch {
				case e: Exception => e.printStackTrace
		}
}

def setSponsor(sponsor: String, id: Int)  = {
		val url = "jdbc:mysql://ada.gonzaga.edu:3306/movieTheater_DB"
		val driver = "com.mysql.jdbc.Driver"
		val username = "jjans"
		val password = "jjans88607111"

		try {
			Class.forName(driver)
			if (connection == null)
				connection = DriverManager.getConnection(url, username, password)
			else
		    null
			var query: String = "UPDATE volunteerOpportunity SET sponsor = ?" + " where volunteerOpportunity_id=" + id
			val statement = connection.prepareStatement(query)
			statement.setString(3,sponsor)
			statement.execute()
		} catch {
				case e: Exception => e.printStackTrace
		}
}

def setDescription(description: String, id: Int)  = {
		val url = "jdbc:mysql://ada.gonzaga.edu:3306/movieTheater_DB"
		val driver = "com.mysql.jdbc.Driver"
		val username = "jjans"
		val password = "jjans88607111"

		try {
			Class.forName(driver)
			if (connection == null)
				connection = DriverManager.getConnection(url, username, password)
			else
		    null
			var query: String = "UPDATE volunteerOpportunity SET description = ?" + " where volunteerOpportunity_id=" + id
			val statement = connection.prepareStatement(query)
			statement.setString(4, description)
			statement.execute()
		} catch {
				case e: Exception => e.printStackTrace
		}
}

def setLocation(location: String, id: Int)  = {
		val url = "jdbc:mysql://ada.gonzaga.edu:3306/movieTheater_DB"
		val driver = "com.mysql.jdbc.Driver"
		val username = "jjans"
		val password = "jjans88607111"

		try {
			Class.forName(driver)
			if (connection == null)
				connection = DriverManager.getConnection(url, username, password)
			else
		    null
			var query: String = "UPDATE volunteerOpportunity SET location = ?" + " where volunteerOpportunity_id=" + id
			val statement = connection.prepareStatement(query)
			statement.setString(5,location)
			statement.execute()
		} catch {
				case e: Exception => e.printStackTrace
		}
}

def setBeginDate(beginDate: String, id: Int)  = {
		val url = "jdbc:mysql://ada.gonzaga.edu:3306/movieTheater_DB"
		val driver = "com.mysql.jdbc.Driver"
		val username = "jjans"
		val password = "jjans88607111"

		try {
			Class.forName(driver)
			if (connection == null)
				connection = DriverManager.getConnection(url, username, password)
			else
		    null
			var query: String = "UPDATE volunteerOpportunity SET beginDate = ?" + " where volunteerOpportunity_id=" + id
			val statement = connection.prepareStatement(query)
			statement.setString(6,beginDate)
			statement.execute()
		} catch {
				case e: Exception => e.printStackTrace
		}
}

def setEndDate(endDate: String, id: Int)  = {
		val url = "jdbc:mysql://ada.gonzaga.edu:3306/movieTheater_DB"
		val driver = "com.mysql.jdbc.Driver"
		val username = "jjans"
		val password = "jjans88607111"

		try {
			Class.forName(driver)
			if (connection == null)
				connection = DriverManager.getConnection(url, username, password)
			else
		    null
			var query: String = "UPDATE volunteerOpportunity SET endDate = ?" + " where volunteerOpportunity_id=" + id
			val statement = connection.prepareStatement(query)
			statement.setString(7, endDate)
			statement.execute()
		} catch {
				case e: Exception => e.printStackTrace
		}
}

def deleteOpportunity(id: Int)  = {
		    val url = "jdbc:mysql://ada.gonzaga.edu:3306/movieTheater_DB"
		    val driver = "com.mysql.jdbc.Driver"
		    val username = "jjans"
		    val password = "jjans88607111"
				try {
					Class.forName(driver)
					if (connection == null)
						connection = DriverManager.getConnection(url, username, password)
					else
		        null
					var query: String = " delete from volunteerOpportunity where volunteerOppotunity_id =" + "?"
					val statement = connection.prepareStatement(query)
					statement.setInt(1, id)
					statement.execute()
				} catch {
				  case e: Exception => e.printStackTrace
				}
}  

}


