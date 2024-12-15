CREATE OR REPLACE FUNCTION  update_appointments_status()
RETURNS TRIGGER AS
$$
BEGIN
    IF NEW.appointment_date<CURRENT_DATE THEN
UPDATE appointment
SET status = 'geçmiş'
WHERE appointment_id=NEW.appointment_id;
END IF;
RETURN NEW;
END ;
$$
LANGUAGE plpgsql;