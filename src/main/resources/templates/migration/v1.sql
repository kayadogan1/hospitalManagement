CREATE OR REPLACE FUNCTION add_patient(
    p_first_name VARCHAR,
    p_last_name VARCHAR,
    p_gender    VARCHAR
)
    RETURNS VOID AS
$$
BEGIN
    INSERT INTO patient (first_name,gender ,last_name)
    VALUES (p_first_name,p_gender , p_last_name);
END;
$$
    LANGUAGE plpgsql;
