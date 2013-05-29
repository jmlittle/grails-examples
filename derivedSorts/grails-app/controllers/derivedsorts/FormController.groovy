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
        [formInstanceList: ExampleForm.list(params), formInstanceTotal: ExampleForm.count()]
	}
	
}
