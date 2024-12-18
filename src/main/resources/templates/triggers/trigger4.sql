CREATE TRIGGER appointmen_add_log_trigger
AFTER INSERT ON appointment
FOR EACH ROW
EXECUTE FUNCTION log_appointment_add();