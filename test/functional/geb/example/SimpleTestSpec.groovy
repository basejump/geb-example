package geb.example

import geb.spock.GebSpec

class SimpleTestSpec extends GebSpec {

	def "sanity check list page"() {
		given:
		go "idea/list"

		expect: "it to contain the basic header"
		driver.pageSource.contains("<h1>Idea List</h1>")
		
		when:
		println driver.pageSource
		
		then:
		title == "Idea List"
		//pageSource gives entire page
		driver.pageSource.contains("<h1>Idea List</h1>")

		when: "create is clicked"
		$("div.nav a.create").click()

		then: "make sure it has the right title"
		title == "Create Idea"
		//driver.pageSource.contains("<h1>Idea List</h1>")
	}
}
