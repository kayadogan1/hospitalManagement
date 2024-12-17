CREATE OR REPLACE PROCEDURE update_patient(
    p_id INTEGER,
    p_name VARCHAR,
    p_surname VARCHAR,
    p_gender VARCHAR
)

AS $$
BEGIN
    UPDATE patient SET first_name=p_name, last_name=p_surname, gender=p_gender WHERE id=p_id;
END;
$$ LANGUAGE plpgsql;