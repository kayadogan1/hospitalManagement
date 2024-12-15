CREATE TRIGGER generate_invoice_after_appointment
AFTER INSERT OR UPDATE ON appointment
FOR EACH ROW
EXECUTE FUNCTION create_invoice_after_appointment();