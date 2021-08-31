package che.vlvl.springjdbc.controller

import che.vlvl.springjdbc.dao.PersonDao
import che.vlvl.springjdbc.dao.PlainJDBCPersonDao
import che.vlvl.springjdbc.model.Person
import org.springframework.web.bind.annotation.*

@RestController
class PersonController(val dao: PersonDao, val jdbcDao: PlainJDBCPersonDao) {

    @PostMapping("/insert")
    fun insert(@RequestBody person: Person) = dao.insertPerson(person)

    @PostMapping("/delete/{id}")
    fun deleteById(@PathVariable id: Long) = dao.deleteById(id)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = dao.getById(id)

    @GetMapping("/all")
    fun getAll() = dao.getAll()

    @GetMapping("/plain-all")
    fun getAllPlainJdbc() = jdbcDao.getAll()

    @GetMapping("/count")
    fun count() = dao.count()

}
