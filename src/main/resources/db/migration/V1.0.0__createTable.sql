CREATE SCHEMA TEST;
CREATE TABLE TEST.REGISTRYHASH (
  id              IDENTITY NOT NULL PRIMARY KEY,
  mapKey          VARCHAR(50),
  value           VARCHAR(50)
);
