CREATE OR REPLACE FUNCTION log_appointment_add()
RETURNS TRIGGER AS $$
    BEGIN
        INSERT INTO randevu_log(randevu_id, eklenme_tarihi)
        VALUES ( NEW.appointment_id,NOW());
        RETURN NEW;

    END;
    $$ LANGUAGE plpgsql;