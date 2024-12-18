CREATE OR REPLACE FUNCTION update_appointments_status()
    RETURNS TRIGGER AS
$$
BEGIN
    -- Eğer randevu tarihi bugünden önceyse, status'u 'geçmiş' olarak ayarla
    IF NEW.appointment_date < CURRENT_DATE THEN
        NEW.status := 'geçmiş';
    END IF;
    RETURN NEW; -- Değiştirilen NEW kaydını döndür
END;
$$
    LANGUAGE plpgsql;