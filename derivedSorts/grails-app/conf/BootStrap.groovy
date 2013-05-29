import grails.util.Environment

class BootStrap {
	def dataBootstrapService
		
    def init = { servletContext ->
		switch (Environment.current) {
			case Environment.DEVELOPMENT:
				dataBootstrapService.createInitialDataIfRequired()
				break;
			case Environment.PRODUCTION:
				println "No special configuration required"
				dataBootstrapService.createInitialDataIfRequired()
				break;
			}
    }
    def destroy = {
    }
}
