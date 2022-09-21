package io.qejo.sonda.infra.db;

import org.springframework.data.jdbc.core.JdbcAggregateTemplate;

abstract class UpsertDAO<T, ID> {

    protected final JdbcAggregateTemplate template;

    UpsertDAO(JdbcAggregateTemplate template) {
        this.template = template;
    }

    T save(T record) {
        boolean exists = template.existsById(retrieveId(record), retrieveClass());

        if (exists) {
            return template.update(record);
        }
        return template.insert(record);
    }

    protected abstract ID retrieveId(T record);
    protected abstract Class<T> retrieveClass();
}
