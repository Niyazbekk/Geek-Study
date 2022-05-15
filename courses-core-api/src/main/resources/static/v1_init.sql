CREATE TABLE t_course
(
    id                 BIGINT NOT NULL,
    userid             integer,
    course_name        VARCHAR(255),
    course_description VARCHAR(255),
    CONSTRAINT pk_t_courses PRIMARY KEY (id)
);

SELECT * from t_course;
DROP TABLE t_course;