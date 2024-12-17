CREATE OR REPLACE PROCEDURE delete_appointment(
    p_appointment_id INTEGER
)
AS $$
    BEGIN
        DELETE FROM appointment
        WHERE appointment_id=p_appointment_id;


    END;
    $$ LANGUAGE plpgsql;
