CREATE TABLE merchant
(
    id           BIGSERIAL
        CONSTRAINT merchant_pk
            PRIMARY KEY,
    name         CHARACTER VARYING(120) NOT NULL,
    address      CHARACTER VARYING(120),
    status       INT DEFAULT 1          NOT NULL,
    org_id       BIGSERIAL              NOT NULL,
    time_created TIMESTAMP,
    time_updated TIMESTAMP,
    CONSTRAINT fk_organization
        FOREIGN KEY (org_id)
            REFERENCES organization (id)
);


CREATE TRIGGER time_created
    BEFORE INSERT
    ON merchant
    FOR EACH ROW
EXECUTE PROCEDURE time_created();


CREATE TRIGGER time_updated
    BEFORE UPDATE
    ON merchant
    FOR EACH ROW
EXECUTE PROCEDURE time_updated();