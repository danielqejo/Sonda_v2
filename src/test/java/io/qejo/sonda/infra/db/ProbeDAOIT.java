package io.qejo.sonda.infra.db;

import io.qejo.sonda.IntegrationTest;
import io.qejo.sonda.infra.db.ProbeDAO;
import io.qejo.sonda.infra.db.ProbeRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ProbeDAOIT extends IntegrationTest {

    @Autowired
    private ProbeDAO subject;

    @Test
    @Sql("classpath:tc/insert_plateau.sql")
    void shouldSaveNormally() {
        ProbeRecord probeRecord =
                new ProbeRecord("teste", "teste", 'N', 1, 1);

        subject.save(probeRecord);

        Optional<ProbeRecord> probeSearched = subject.findById(probeRecord.name());

        assertFalse(probeSearched.isEmpty());
        assertEquals(probeRecord, probeSearched.get());
    }

}
