CREATE OR REPLACE FUNCTION create_invoice_after_appointment()
    RETURNS TRIGGER AS
$$
BEGIN
    INSERT INTO invoice(patient_id, amount, description, title)
    VALUES(NEW.patient_id, 1000, NEW.appointment_description, NEW.appointment_title);

    UPDATE patient
    SET invoice_invoice_id = (SELECT invoice_id FROM invoice WHERE patient_id = NEW.patient_id ORDER BY invoice_id DESC LIMIT 1)
    WHERE id = NEW.patient_id;

    RETURN NEW;
END;
$$
    LANGUAGE plpgsql;
