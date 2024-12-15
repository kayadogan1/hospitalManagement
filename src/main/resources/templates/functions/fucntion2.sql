CREATE OR REPLACE FUNCTION create_invoice_after_appointment()
RETURNS TRIGGER AS
$$
BEGIN
    INSERT INTO invoice(patient_id,amount,description,title)
    VALUES(NEW.patient_id,NEW.amount,NEW.description,NEW.title);
    RETURN NEW;
END;
$$

LANGUAGE plpgsql;