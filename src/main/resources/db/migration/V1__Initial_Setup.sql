-- Example migration script for setting up the initial database
CREATE TABLE CREW (
                      id UUID PRIMARY KEY,
                      name VARCHAR(255) NOT NULL
);

CREATE TABLE CHARACTERS (
                            id UUID PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            faction VARCHAR(255),
                            role VARCHAR(255) NOT NULL,
                            crew_id UUID,
                            FOREIGN KEY (crew_id) REFERENCES CREW(id) ON DELETE SET NULL
);