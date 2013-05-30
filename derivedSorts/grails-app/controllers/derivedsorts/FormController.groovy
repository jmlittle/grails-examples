package derivedsorts

class FormController {

    def index() {
	 	redirect (action: "list", params: params)
	}
	
	@Category(List) // From Colin Harrington's post
	class PaginateableList {
		List paginate(max, offset=0 ) 
		{
			((max as Integer) <= 0 || (offset as Integer) < 0) ? [] : this.subList( Math.min( offset as Integer, this.size() ), Math.min( (offset as Integer) + (max as Integer), this.size() ) )
		}
	}
	
	def list(Integer max, Integer offset, String sort, String order) {
		params.max = Math.min(max ?: 20, 100)
		params.offset = offset ?: 0  // require offset for pagination
		params.sort = sort ?: 'courseName'
		params.order = order ?: 'asc'
		def total = ExampleForm.count()
		def forms
		if (params.sort == 'courseName')
		 	forms = ExampleForm.list(params)
		else if (sort in ['fullName', 'status'])
			use(PaginateableList) {
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
			forms = forms.paginate(params.max, params.offset)
			
			}
        [formInstanceList: forms, formInstanceTotal: ExampleForm.count()]
	}
	
}
