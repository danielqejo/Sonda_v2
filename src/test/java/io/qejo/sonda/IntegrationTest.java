package io.qejo.sonda;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@SpringBootTest
public abstract class IntegrationTest {

    @Container
    protected static final PostgreSQLContainer POSTGRE_SQL_CONTAINER =
            new PostgreSQLContainer(DockerImageName.parse("postgres:14.5"));


    @DynamicPropertySource
    private static void postgresProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRE_SQL_CONTAINER::getJdbcUrl);
        registry.add("spring.flyway.url", POSTGRE_SQL_CONTAINER::getJdbcUrl);
    }

}
