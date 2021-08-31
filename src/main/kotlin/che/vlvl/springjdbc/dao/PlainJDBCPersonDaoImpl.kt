package che.vlvl.springjdbc.dao

import che.vlvl.springjdbc.model.Person
import org.springframework.stereotype.Repository
import java.sql.Connection
import java.sql.PreparedStatement
import javax.sql.DataSource


@Repository
class PlainJDBCPersonDaoImpl(datasource: DataSource) : PlainJDBCPersonDao {
    private val connection: Connection = datasource.connection
    private val preparedStatement: PreparedStatement = connection.prepareStatement("SELECT * FROM PERSONS")

    /**
     * Реализация метода получения всех людей на чистом JDBC
     */
    override fun getAll(): List<Person> {

        val resultSet = preparedStatement.executeQuery()

        val resultList = mutableListOf<Person>()
        while (resultSet.next()) {
            resultList.add(
                Person(
                    id = resultSet.getLong("id"),
                    name = resultSet.getString("name"),
                    age = resultSet.getInt("age")
                )
            )
        }

        return resultList
    }
}