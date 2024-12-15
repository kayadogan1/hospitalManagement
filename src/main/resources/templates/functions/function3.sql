CREATE OR REPLACE FUNCTION set_patient_creation_time()
RETURNS TRIGGER AS
$$
BEGIN
    NEW.creation_time:=CURRENT_TIMESTAMP;
    RETURN NEW;
end;
$$
LANGUAGE plpgsql;