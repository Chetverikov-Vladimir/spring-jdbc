package che.vlvl.springjdbc.dao

import che.vlvl.springjdbc.model.Person
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.context.annotation.Import

@JdbcTest
@Import(PersonDaoTemplateImpl::class)
class PersonDaoTemplateImplTest {

    private val expectedCount = 2
    private val sashaId = 1L

    @Autowired
    lateinit var dao: PersonDaoTemplateImpl

    @Test
    fun shouldInsertPerson() {
        val testPerson = Person(999, "Test", 999)
        dao.insertPerson(testPerson)
        assert(dao.getById(testPerson.id) == testPerson)
    }

    @Test
    fun shouldReturnExpectedPersonById() {
        val actualSasha = dao.getById(sashaId)
        assert(actualSasha == Person(1, "Sasha", 27))
    }

    @Test
    fun shouldReturnExpectedPersonList() {
        val actualList = dao.getAll()
        assert(actualList.size == expectedCount)
        assert(actualList[0] == Person(1, "Sasha", 27))
        assert(actualList[1] == Person(2, "Misha", 18))
    }

    @Test
    fun shouldReturnExpectedPersonCount() {
        val actualCount = dao.count()
        assert(actualCount == expectedCount)
    }
}