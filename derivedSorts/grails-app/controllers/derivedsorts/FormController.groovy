package derivedsorts

class FormController {

    def index() {
	 	redirect (action: "list", params: params)
	}
	
	def list(Integer max, Integer offset, String sort, String order) {
		params.max = Math.min(max ?: 20, 100)
		params.offset = offset
		params.sort = sort ?: 'courseName'
		params.order = order ?: 'asc'
		def total = ExampleForm.count()
		def forms
		if (params.sort == 'courseName')
		 	forms = ExampleForm.list(params)
		else if (sort in ['fullName', 'status'])
			if (sort != 'fullName')  // sort secondarily on fullName
			{
				if (order == 'desc') {
					// sort on secondary criteria first, always ascending on second criteria
					forms = ExampleForm.list().sort { p1, p2 -> (p1.fullName() <=> p2.fullName())}
					forms = forms.sort { p1, p2 -> -(p1."$sort"() <=> p2."$sort"())}
				}
				else {
					forms = ExampleForm.list().sort { p1, p2 -> (p1.fullName() <=> p2.fullName())}
					forms = forms.sort { p1, p2 -> p1."$sort"() <=> p2."$sort"()}
					
				}
			}
			else 
			{
				if (order == 'desc')
					forms = ExampleForm.list().sort { p1, p2 -> -(p1."$sort"() <=> p2."$sort"())}
				else
					forms = ExampleForm.list().sort { p1, p2 -> p1."$sort"() <=> p2."$sort"()}
			}
        [formInstanceList: forms, formInstanceTotal: total]
	}
	
}
