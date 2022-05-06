package springrestapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

data class Employee(val id: String, val fullName: String, val location: String, val jobTitle: String)

@SpringBootApplication
@RestController
class WebApp {

    val employees = listOf(
        Employee("300", "Walt Longmire", "WYG", "Sheriff"),
        Employee("301", "Vic Moretti", "WYG", "Deputy"),
    )

    @GetMapping("/employees")
    fun getAllEmployees(): List<Employee> = employees

}


fun main(args: Array<String>) {
    runApplication<WebApp>(*args)
}