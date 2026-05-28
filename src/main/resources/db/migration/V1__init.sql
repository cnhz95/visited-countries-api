CREATE TABLE users (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username TEXT NOT NULL,
    CONSTRAINT chk_users_username_nonempty CHECK (trim(username) <> ''),
    CONSTRAINT uq_users_username UNIQUE (username)
);

CREATE TABLE countries (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL,
    region TEXT NOT NULL,
    population INTEGER NOT NULL,
    CONSTRAINT chk_countries_region_nonempty CHECK (trim(region) <> ''),
    CONSTRAINT chk_countries_population_non_negative CHECK (population >= 0)
);

CREATE TABLE visited_countries (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users (id),
    country_id INTEGER NOT NULL REFERENCES countries (id),
    note TEXT,
    CONSTRAINT uq_visited_countries_user_country UNIQUE (user_id, country_id)
);
