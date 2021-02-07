-- changeset account:uvashish:1

CREATE TABLE IF NOT EXISTS account(
    sid BIGINT NOT NULL AUTO_INCREMENT,
    account_id VARCHAR(40) NOT NULL,
    account_type VARCHAR(30) NOT NULL,
    payload TEXT NULL,
    status VARCHAR(30) NOT NULL,
    crt_ts DATETIME NOT NULL,
    chg_ts DATETIME NOT NULL,
    PRIMARY KEY (sid),
    INDEX idx_se1 (account_type, status, account_id)
);