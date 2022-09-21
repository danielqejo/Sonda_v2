package io.qejo.sonda.infra.db;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class ProbeDAO extends UpsertDAO<ProbeRecord, String> {

    ProbeDAO(JdbcAggregateTemplate template) {
        super(template);
    }

    @Override
    protected String retrieveId(ProbeRecord record) {
        return record.name();
    }

    @Override
    protected Class<ProbeRecord> retrieveClass() {
        return ProbeRecord.class;
    }

    Optional<ProbeRecord> findById(String probeName) {
        return Optional.ofNullable(template.findById(probeName, ProbeRecord.class));
    }

}
