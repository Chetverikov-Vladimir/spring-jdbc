package che.vlvl.springjdbc.dao

import che.vlvl.springjdbc.model.Person

interface PlainJDBCPersonDao {

    fun getAll(): List<Person>
}