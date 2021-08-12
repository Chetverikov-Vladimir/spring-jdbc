package che.vlvl.springjdbc.dao

import che.vlvl.springjdbc.model.Person

interface PersonDao {
    fun insertPerson(person: Person): Int

    fun deleteById(id: Long): Int

    fun getById(id: Long): Person?
    fun getAll(): List<Person>

    fun count(): Int
}