package derivedsorts

class ExampleForm {
	String firstName
	String lastName
	String courseName
	Date dateSubmitted
	Date dateApproved

    static constraints = {
		firstName nullable : false
		lastName nullable : false
		courseName nullable : true
		dateSubmitted nullable : true
		dateApproved nullable : true
    }

	String status() {
		def statusString = ""
		if (!dateSubmitted)
			statusString = "Not Submitted"
		else if (dateSubmitted && !dateApproved)
			statusString = "Submitted for Approval"
		else if (dateApproved)
			statusString = "Approved"
	        return statusString
	}       

	String fullName() {
		"${lastName}, ${firstName}"
	}
}
