package io.qejo.sonda.infra.db;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class PlateauDAO extends UpsertDAO<PlateauRecord, String> {

    PlateauDAO(JdbcAggregateTemplate template) {
        super(template);
    }

    @Override
    protected String retrieveId(PlateauRecord record) {
        return record.name();
    }

    @Override
    protected Class<PlateauRecord> retrieveClass() {
        return PlateauRecord.class;
    }

    Optional<PlateauRecord> findById(String name) {
        return Optional.ofNullable(template.findById(name, PlateauRecord.class));
    }

}
