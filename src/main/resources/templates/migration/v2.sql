CREATE OR REPLACE PROCEDURE assign_patient_to_doctor(p_patient_id INTEGER, p_doctor_id INT)
AS $$
BEGIN
    INSERT INTO doctor_patient(doctor_id, patient_id)
    VALUES (p_doctor_id,p_patient_id);
END;

$$
LANGUAGE plpgsql;

