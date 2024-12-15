CREATE TRIGGER trigger_set_patient_creation_time
BEFORE INSERT ON patient
FOR EACH ROW
EXECUTE FUNCTION set_patient_creation_time();