package io.qejo.sonda.infra.db;

import io.qejo.sonda.IntegrationTest;
import io.qejo.sonda.infra.db.PlateauDAO;
import io.qejo.sonda.infra.db.PlateauRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PlateauDAOIT extends IntegrationTest {

    @Autowired
    private PlateauDAO subject;

    @Test
    public void shouldSaveFirstTimeProperly() {
        PlateauRecord expectedRecord = new PlateauRecord("EITA", 1, 2);
        subject.save(expectedRecord);

        Optional<PlateauRecord> result = subject.findById("EITA");

        assertFalse(result.isEmpty());
        assertEquals(expectedRecord, result.get());
    }

    @Test
    void shouldInsertAndUpdateAfterFirstTime() {
        subject.save(new PlateauRecord("EITA", 1, 2));
        PlateauRecord expectedRecord = new PlateauRecord("EITA", 1, 3);
        subject.save(expectedRecord);

        Optional<PlateauRecord> result = subject.findById("EITA");

        assertFalse(result.isEmpty());
        assertEquals(expectedRecord, result.get());
    }

}
