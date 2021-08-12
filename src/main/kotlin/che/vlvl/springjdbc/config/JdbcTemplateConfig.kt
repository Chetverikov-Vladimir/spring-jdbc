package che.vlvl.springjdbc.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

@Configuration
class JdbcTemplateConfig {
    //Автоматически создается Spring. Можно не переопределять
    @Bean
    fun jdbcTemplate(datasource: DataSource) = JdbcTemplate(datasource)
}