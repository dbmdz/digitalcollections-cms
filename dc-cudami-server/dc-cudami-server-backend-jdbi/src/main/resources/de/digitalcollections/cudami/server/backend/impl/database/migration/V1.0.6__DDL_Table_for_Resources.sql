CREATE TABLE IF NOT EXISTS resources (
  id SERIAL PRIMARY KEY NOT NULL,
  uuid UUID NOT NULL UNIQUE,

  resource_type VARCHAR NOT NULL
);