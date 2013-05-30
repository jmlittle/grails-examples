package derivedsorts

class DataBootstrapService {

    def createInitialDataIfRequired() {
			if (!ExampleForm.findByLastName("White"))
			{
				println "Uninitialized database. Creating defaults"

				def whiteForm = new ExampleForm(firstName: 'Betty', lastName: 'White', courseName: "EE 272", dateSubmitted: new Date().parse("dd-MM-yyyy", "10-12-2005")).save(failOnError: true)
				def brownForm = new ExampleForm(firstName: 'Charlie', lastName: 'Brown', courseName: "EE 400", dateSubmitted: new Date().parse("dd-MM-yyyy","11-03-2005")).save(failOnError: true)
				def redForm = new ExampleForm(firstName: 'Alice', lastName: 'Red', courseName: "EE 102A", dateSubmitted: new Date().parse("dd-MM-yyyy","01-22-2009"), dateApproved: new Date().parse("dd-MM-yyyy","03-01-2009")).save(failOnError: true)
				def greenForm = new ExampleForm(firstName: 'Isaac', lastName: 'Green', courseName: "EE 102A", dateSubmitted: new Date().parse("dd-MM-yyyy","04-20-2013"), dateApproved: new Date().parse("dd-MM-yyyy","04-21-2013")).save(failOnError: true)
				def blueForm = new ExampleForm(firstName: 'Ralph', lastName: 'Blue', courseName: "EE 300").save(failOnError: true)
				def orangeForm = new ExampleForm(firstName: 'George', lastName: 'Orange', courseName: "EE 272").save(failOnError: true)
				for (i in 1..25) {
					def newForm = new ExampleForm(firstName: 'John', lastName: "Doe${i}", courseName: "CS ${i}").save(failOnError: true)
				}
			}
	    }
}