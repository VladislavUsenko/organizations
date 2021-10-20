CREATE TABLE organization
(
    id            BIGSERIAL
        CONSTRAINT organization_pk
            PRIMARY KEY,
    org_name      CHARACTER VARYING(120) NOT NULL,
    org_account   CHARACTER VARYING(15)  NOT NULL,
    legal_address CHARACTER VARYING(120),
    org_status    INT DEFAULT 1          NOT NULL,
    time_created  TIMESTAMP,
    time_updated  TIMESTAMP
);


CREATE FUNCTION time_created() RETURNS trigger AS
$time_created$
BEGIN
    NEW.time_created := current_timestamp;
    IF NEW.time_updated IS NULL THEN
        NEW.time_updated := current_timestamp;
    END IF;
    RETURN NEW;
END;
$time_created$ LANGUAGE plpgsql;

CREATE TRIGGER time_created
    BEFORE INSERT
    ON organization
    FOR EACH ROW
EXECUTE PROCEDURE time_created();

CREATE FUNCTION time_updated() RETURNS trigger AS
$time_updated$
BEGIN
    NEW.time_updated := current_timestamp;
    RETURN NEW;
END;
$time_updated$ LANGUAGE plpgsql;

CREATE TRIGGER time_updated
    BEFORE UPDATE
    ON organization
    FOR EACH ROW
EXECUTE PROCEDURE time_updated();