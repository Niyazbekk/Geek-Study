CREATE TABLE t_enroll
(
    id                 BIGINT NOT NULL,
    userid             BIGINT,
    courseid        BIGINT,
    CONSTRAINT pk_t_enroll PRIMARY KEY (id)
);

SELECT * from t_enroll;
DROP TABLE t_enroll;