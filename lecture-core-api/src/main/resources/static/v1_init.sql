CREATE TABLE t_lecture
(
    id              BIGINT NOT NULL,
    courseid        BIGINT,
    lecture_message VARCHAR(255),
    CONSTRAINT pk_t_lecture PRIMARY KEY (id)
);

SELECT * FROM t_lecture;
SELECT * FROM t_attach;

DROP TABLE t_attach;

CREATE TABLE t_attach
(
    id        VARCHAR(255) NOT NULL,
    courseid  BIGINT,
    file_name VARCHAR(255),
    file_type VARCHAR(255),
    data      OID,
    CONSTRAINT pk_t_attach PRIMARY KEY (id)
);