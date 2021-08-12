package che.vlvl.springjdbc.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource

@Configuration
class DatasourceConfig {

    /**
     * По умолчанию поднимается сам, нужно указать необходимые настройки в application.yml
     */
    @Bean
    fun h2Datasource() = DriverManagerDataSource().apply {
        setDriverClassName("org.h2.Driver")
        //Если не добавить ;DB_CLOSE_DELAY=-1, то созданные из schema.sql таблицы для базы типа mem будут потеряны
        //https://stackoverflow.com/questions/5763747/h2-in-memory-database-table-not-found
        url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"
        //Стандартные пользователь и пустой пароль
        username = "sa"
        password = ""
    }
}