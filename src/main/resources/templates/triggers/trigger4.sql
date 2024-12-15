CREATE TRIGGER after_room_assignment_insert
AFTER INSERT ON hospital_rooms
FOR EACH ROW
EXECUTE FUNCTION check_room_capacity();