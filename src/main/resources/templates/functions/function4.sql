CREATE OR REPLACE FUNCTION check_room_capacity()
RETURNS TRIGGER AS
$$
BEGIN
    UPDATE hospital_rooms
    SET bed_count= bed_count+1
    WHERE room_id=NEW.room_id;

    IF(SELECT hospital_rooms.bed_count FROM hospital_rooms WHERE room_id=NEW.room_id)>
      (SELECT hospital_rooms.capacity FROM hospital_rooms WHERE room_id=NEW.room_id) THEN
        RAISE EXCEPTION 'ROOM % IS FULL! CAN NOT ASSIGN MORE PATIENTS',NEW.room_id;
    end if;
    RETURN NEW;
end;
$$
LANGUAGE plpgsql;