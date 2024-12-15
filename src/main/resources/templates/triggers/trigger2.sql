
CREATE TRIGGER trigger_update_appointment_status
AFTER INSERT OR UPDATE ON appointment
FOR EACH ROW
EXECUTE FUNCTION update_appointments_status();