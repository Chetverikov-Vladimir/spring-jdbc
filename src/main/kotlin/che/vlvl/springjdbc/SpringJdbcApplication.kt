package che.vlvl.springjdbc

import org.h2.tools.Console
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringJdbcApplication

fun main(args: Array<String>) {
	runApplication<SpringJdbcApplication>(*args)
	Console.main(*args)
}
