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
    protected static final PostgresContainer POSTGRE_SQL_CONTAINER;

    static {
        POSTGRE_SQL_CONTAINER = new PostgresContainer();
        POSTGRE_SQL_CONTAINER.start();
    }

    @DynamicPropertySource
    private static void postgresProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRE_SQL_CONTAINER::getJdbcUrl);
        registry.add("spring.flyway.url", POSTGRE_SQL_CONTAINER::getJdbcUrl);
    }

    static class PostgresContainer extends PostgreSQLContainer<PostgresContainer> {

        public PostgresContainer() {
            super(DockerImageName.parse("postgres:14.5"));
        }

        @Override
        public void stop() {
            // Do Nothing
        }
    }

}
