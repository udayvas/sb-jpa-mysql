-- changeset staging:uvashish:1

CREATE TABLE IF NOT EXISTS staging(
    sid BIGINT NOT NULL AUTO_INCREMENT,
    entity_id VARCHAR(40) NOT NULL,
    entity_type VARCHAR(30) NOT NULL,
    request_type VARCHAR(30) NOT NULL,
    staging_operation VARCHAR(30) NOT NULL,
    payload TEXT NULL,
    status VARCHAR(30) NOT NULL,
    activation_date DATE NOT NULL,
    error TEXT NULL,
    crt_ts DATETIME NOT NULL,
    chg_ts DATETIME NOT NULL,
    PRIMARY KEY (sid),
    INDEX idx_se1 (entity_type, status, entity_id)
);
