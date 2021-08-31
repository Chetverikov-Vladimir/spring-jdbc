package che.vlvl.springjdbc.dao

import che.vlvl.springjdbc.model.Person
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.stereotype.Repository

@Repository
class PersonDaoTemplateImpl(val jdbcTemplate: NamedParameterJdbcOperations) : PersonDao {
    override fun insertPerson(person: Person): Int = if (getById(person.id) == null) {
        jdbcTemplate.update(
            "INSERT INTO PERSONS (ID, NAME, AGE) VALUES (:id, :name, :age)",
            mapOf(
                "id" to person.id,
                "name" to person.name,
                "age" to person.age
            )
        )
    } else 0

    override fun deleteById(id: Long) = jdbcTemplate.update(
        "DELETE FROM PERSONS WHERE ID=:id",
        mapOf("id" to id)
    )

    // Используется ResultSetExtractor
    override fun getById(id: Long) = jdbcTemplate.query(
        "SELECT * FROM PERSONS WHERE ID=:id",
        mapOf("id" to id),
        ResultSetExtractor { rs ->
            rs.next()
            if (rs.isLast) Person(
                id = rs.getLong("id"),
                name = rs.getString("name"),
                age = rs.getInt("age")
            )
            else null
        }
    )

    // Используется RowMapper, для более специфичных случаев можно использовать
    // перегруженные версии, например, с ResultSetExtractor
    override fun getAll(): List<Person> = jdbcTemplate.query(
        "SELECT * FROM PERSONS"
    ) { rs, _ ->
        Person(
            id = rs.getLong("id"),
            name = rs.getString("name"),
            age = rs.getInt("age")
        )
    }

    override fun count() =
        jdbcTemplate.jdbcOperations.queryForObject("SELECT COUNT(*) FROM PERSONS", Int::class.java) ?: 0

}