CREATE SCHEMA IF NOT EXISTS public;

CREATE SEQUENCE public.randevu_log_id_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE  TABLE public.clinic ( 
	id                   integer  NOT NULL GENERATED  BY DEFAULT AS IDENTITY ,
	clinic_address       varchar(255)    ,
	clinic_name          varchar(255)    ,
	CONSTRAINT clinic_pkey PRIMARY KEY ( id )
 );

CREATE  TABLE public.hospital_rooms ( 
	room_id              integer  NOT NULL GENERATED  BY DEFAULT AS IDENTITY ,
	bed_count            integer  NOT NULL  ,
	room_number          integer  NOT NULL  ,
	CONSTRAINT hospital_rooms_pkey PRIMARY KEY ( room_id )
 );

CREATE  TABLE public.personel ( 
	personel_type        varchar(31)  NOT NULL  ,
	id                   integer  NOT NULL GENERATED  BY DEFAULT AS IDENTITY ,
	name                 varchar(255)  NOT NULL  ,
	surname              varchar(255)  NOT NULL  ,
	address              varchar(255)    ,
	identity_no          varchar(255)  NOT NULL  ,
	title                varchar(255)  NOT NULL  ,
	CONSTRAINT personel_pkey PRIMARY KEY ( id ),
	CONSTRAINT ukijttljn5lo8rpm9umb6p6kuyw UNIQUE ( identity_no ) 
 );

CREATE  TABLE public.randevu_log ( 
	id                   serial  NOT NULL  ,
	randevu_id           integer    ,
	eklenme_tarihi       timestamp    ,
	CONSTRAINT randevu_log_pkey PRIMARY KEY ( id )
 );

CREATE  TABLE public.beds ( 
	bed_id               integer  NOT NULL GENERATED  BY DEFAULT AS IDENTITY ,
	room_name            varchar(255)    ,
	status               boolean  NOT NULL  ,
	room_id              integer    ,
	CONSTRAINT beds_pkey PRIMARY KEY ( bed_id )
 );

CREATE  TABLE public.doctor ( 
	speciality           varchar(255)  NOT NULL  ,
	id                   integer  NOT NULL  ,
	clinic_doktor        integer  NOT NULL  ,
	CONSTRAINT doctor_pkey PRIMARY KEY ( id )
 );

CREATE  TABLE public.nurse ( 
	id                   integer  NOT NULL  ,
	clinic_id            integer    ,
	CONSTRAINT nurse_pkey PRIMARY KEY ( id )
 );

CREATE  TABLE public.clinic_doctors ( 
	clinic_id            integer  NOT NULL  ,
	doctors_id           integer  NOT NULL  ,
	CONSTRAINT ukm2fqkorxrltscphn4v4sxjt0u UNIQUE ( doctors_id ) 
 );

CREATE  TABLE public.clinic_nurses ( 
	clinic_id            integer  NOT NULL  ,
	nurses_id            integer  NOT NULL  ,
	CONSTRAINT ukdp97rm6jixx79gkgxct4tu7ee UNIQUE ( nurses_id ) 
 );

CREATE  TABLE public.appointment ( 
	appointment_id       integer  NOT NULL GENERATED  BY DEFAULT AS IDENTITY ,
	appointment_date     date    ,
	appointment_description varchar(255)    ,
	appointment_time     timestamp    ,
	appointment_title    varchar(255)    ,
	doctor_id            integer    ,
	patient_id           integer    ,
	status               varchar(255)    ,
	CONSTRAINT appointment_pkey PRIMARY KEY ( appointment_id )
 );

CREATE  TABLE public.doctor_patient ( 
	patient_id           integer  NOT NULL  ,
	doctor_id            integer  NOT NULL  
 );

CREATE  TABLE public.invoice ( 
	invoice_id           integer  NOT NULL GENERATED  BY DEFAULT AS IDENTITY ,
	amount               integer  NOT NULL  ,
	description          varchar(255)    ,
	title                varchar(255)    ,
	patient_id           integer    ,
	CONSTRAINT invoice_pkey PRIMARY KEY ( invoice_id ),
	CONSTRAINT ukegehl9t90tgxc2yfdnnxedb UNIQUE ( patient_id ) 
 );

CREATE  TABLE public.lab_results ( 
	result_id            integer  NOT NULL GENERATED  BY DEFAULT AS IDENTITY ,
	notes                varchar(255)    ,
	"result"             varchar(255)    ,
	lab_test_id          integer    ,
	patient_id           integer    ,
	CONSTRAINT lab_results_pkey PRIMARY KEY ( result_id ),
	CONSTRAINT uk1svdonr98y8mv4am0443rb7co UNIQUE ( lab_test_id ) ,
	CONSTRAINT ukgkofw8w2e62hadbf9p16hxo1c UNIQUE ( patient_id ) 
 );

CREATE  TABLE public.lab_tests ( 
	id                   integer  NOT NULL GENERATED  BY DEFAULT AS IDENTITY ,
	test_description     varchar(255)    ,
	test_name            varchar(255)    ,
	lab_result_result_id integer    ,
	CONSTRAINT lab_tests_pkey PRIMARY KEY ( id ),
	CONSTRAINT ukpixo0ptw8xk3ckj3a3vrcg1y1 UNIQUE ( lab_result_result_id ) 
 );

CREATE  TABLE public.patient ( 
	id                   integer  NOT NULL GENERATED  BY DEFAULT AS IDENTITY ,
	first_name           varchar(255)  NOT NULL  ,
	gender               varchar(255)    ,
	last_name            varchar(255)  NOT NULL  ,
	invoice_invoice_id   integer    ,
	lab_result_result_id integer    ,
	prescription_id      integer    ,
	CONSTRAINT patient_pkey PRIMARY KEY ( id ),
	CONSTRAINT ukgfxl66u8trk8smlngod3kp9dn UNIQUE ( invoice_invoice_id ) ,
	CONSTRAINT uklnh1f96i5mo1f5ytwa0dx8awc UNIQUE ( lab_result_result_id ) ,
	CONSTRAINT ukiol9fkeh7fsx3upnm6e0j68ov UNIQUE ( prescription_id ) 
 );

CREATE  TABLE public.patient_appointments ( 
	patient_id           integer  NOT NULL  ,
	appointments_appointment_id integer  NOT NULL  ,
	CONSTRAINT ukb7b9oh1v47h47f9r1b3h7adjd UNIQUE ( appointments_appointment_id ) 
 );

CREATE  TABLE public.prescription ( 
	id                   integer  NOT NULL GENERATED  BY DEFAULT AS IDENTITY ,
	"date"               date    ,
	description          varchar(255)    ,
	time                 timestamp    ,
	title                varchar(255)    ,
	doctor_id            integer    ,
	patient_id           integer    ,
	prescriptions_id     integer    ,
	CONSTRAINT prescription_pkey PRIMARY KEY ( id ),
	CONSTRAINT uk8n1l922yl19syo5v9od4if6b0 UNIQUE ( doctor_id ) ,
	CONSTRAINT ukm2kddffl4300p5tv6o7ssuujj UNIQUE ( patient_id ) 
 );

CREATE  TABLE public.visitor ( 
	id                   integer  NOT NULL GENERATED  BY DEFAULT AS IDENTITY ,
	visitor_name         varchar(255)    ,
	visitor_surname      varchar(255)    ,
	patient_id           integer    ,
	CONSTRAINT visitor_pkey PRIMARY KEY ( id )
 );

ALTER TABLE public.appointment ADD CONSTRAINT fk4apif2ewfyf14077ichee8g06 FOREIGN KEY ( patient_id ) REFERENCES public.patient( id );

ALTER TABLE public.appointment ADD CONSTRAINT fkoeb98n82eph1dx43v3y2bcmsl FOREIGN KEY ( doctor_id ) REFERENCES public.doctor( id );

ALTER TABLE public.beds ADD CONSTRAINT fkmqmnw7gr9tvc1jhdlbj4cgsmg FOREIGN KEY ( room_id ) REFERENCES public.hospital_rooms( room_id );

ALTER TABLE public.clinic_doctors ADD CONSTRAINT fkqpu1mv6pds879afuru3fllsqe FOREIGN KEY ( clinic_id ) REFERENCES public.clinic( id );

ALTER TABLE public.clinic_doctors ADD CONSTRAINT fk3ykc88sbg8rbo0nd5u468asmg FOREIGN KEY ( doctors_id ) REFERENCES public.doctor( id );

ALTER TABLE public.clinic_nurses ADD CONSTRAINT fk1rk8ba0b0in25xdj0cxs4ro6i FOREIGN KEY ( clinic_id ) REFERENCES public.clinic( id );

ALTER TABLE public.clinic_nurses ADD CONSTRAINT fkepjyk6ghjgkheossddkgoih1i FOREIGN KEY ( nurses_id ) REFERENCES public.nurse( id );

ALTER TABLE public.doctor ADD CONSTRAINT fkh07k8mjdtec54oxnwi6vjo2ep FOREIGN KEY ( id ) REFERENCES public.personel( id );

ALTER TABLE public.doctor ADD CONSTRAINT fk997urqsc84w9k378eab37luld FOREIGN KEY ( clinic_doktor ) REFERENCES public.clinic( id );

ALTER TABLE public.doctor_patient ADD CONSTRAINT fkoee3w1lhncf3q845n6vatov1j FOREIGN KEY ( patient_id ) REFERENCES public.patient( id );

ALTER TABLE public.doctor_patient ADD CONSTRAINT fk1vod5519v8g177r669gytdahb FOREIGN KEY ( doctor_id ) REFERENCES public.doctor( id );

ALTER TABLE public.invoice ADD CONSTRAINT fkooyykfsat84yeqr06yx3h5392 FOREIGN KEY ( patient_id ) REFERENCES public.patient( id );

ALTER TABLE public.lab_results ADD CONSTRAINT fkfd0lh3mdse4ucpoa3sahxw6ar FOREIGN KEY ( patient_id ) REFERENCES public.patient( id );

ALTER TABLE public.lab_results ADD CONSTRAINT fke60ngnp0gdnsjf50i3glst95f FOREIGN KEY ( lab_test_id ) REFERENCES public.lab_tests( id );

ALTER TABLE public.lab_tests ADD CONSTRAINT fkcvlsn3prtju1qrjhhlay9bsl0 FOREIGN KEY ( lab_result_result_id ) REFERENCES public.lab_results( result_id );

ALTER TABLE public.nurse ADD CONSTRAINT fk6rpilp1f440duieyprxtchwkn FOREIGN KEY ( id ) REFERENCES public.personel( id );

ALTER TABLE public.nurse ADD CONSTRAINT fk6ark7hfe8dneiy7qjpedq4tvc FOREIGN KEY ( clinic_id ) REFERENCES public.clinic( id );

ALTER TABLE public.patient ADD CONSTRAINT fk2csjpkt571m6knm1vgg4hy9xw FOREIGN KEY ( prescription_id ) REFERENCES public.prescription( id );

ALTER TABLE public.patient ADD CONSTRAINT fkok93e9ymfbe7071xnqng7wrcy FOREIGN KEY ( lab_result_result_id ) REFERENCES public.lab_results( result_id );

ALTER TABLE public.patient ADD CONSTRAINT fk7fcoaek79roq5jbdfgt5obxop FOREIGN KEY ( invoice_invoice_id ) REFERENCES public.invoice( invoice_id );

ALTER TABLE public.patient_appointments ADD CONSTRAINT fk9t5466bjrp5l4ikqlwq7my18m FOREIGN KEY ( patient_id ) REFERENCES public.patient( id );

ALTER TABLE public.patient_appointments ADD CONSTRAINT fke5cng7y1ji3ul5omfta5ubq2r FOREIGN KEY ( appointments_appointment_id ) REFERENCES public.appointment( appointment_id );

ALTER TABLE public.prescription ADD CONSTRAINT fkcmb0s0brqql3rhrj1pkoj1tlt FOREIGN KEY ( prescriptions_id ) REFERENCES public.doctor( id );

ALTER TABLE public.prescription ADD CONSTRAINT fkqrlh184tfvdi95erwl65p4xj3 FOREIGN KEY ( patient_id ) REFERENCES public.patient( id );

ALTER TABLE public.prescription ADD CONSTRAINT fk1ppr8greedyrey8nchpr0v4dn FOREIGN KEY ( doctor_id ) REFERENCES public.doctor( id );

ALTER TABLE public.visitor ADD CONSTRAINT fkiugyqmmsvm9exvj35q67jfu7h FOREIGN KEY ( patient_id ) REFERENCES public.patient( id );

CREATE TRIGGER appointmen_add_log_trigger AFTER INSERT ON public.appointment FOR EACH ROW EXECUTE FUNCTION log_appointment_add();

CREATE TRIGGER generate_invoice_after_appointment BEFORE INSERT OR UPDATE ON public.appointment FOR EACH ROW EXECUTE FUNCTION create_invoice_after_appointment();

CREATE OR REPLACE FUNCTION public.create_invoice_after_appointment()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
BEGIN
    INSERT INTO invoice(patient_id, amount, description, title)
    VALUES(NEW.patient_id, 1000, NEW.appointment_description, NEW.appointment_title);
    UPDATE patient
    SET invoice_invoice_id = (SELECT invoice_id FROM invoice WHERE patient_id = NEW.patient_id ORDER BY invoice_id DESC LIMIT 1)
    WHERE id = NEW.patient_id;
    RETURN NEW;
END;
$function$
;

CREATE OR REPLACE FUNCTION public.log_appointment_add()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
    BEGIN
        INSERT INTO randevu_log(randevu_id, eklenme_tarihi)
        VALUES ( NEW.appointment_id,NOW());
        RETURN NEW;
    END;
    $function$
;

CREATE OR REPLACE FUNCTION public.set_patient_creation_time()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
BEGIN
    NEW.creation_time:=CURRENT_TIMESTAMP;
    RETURN NEW;
end;
$function$
;

CREATE OR REPLACE FUNCTION public.update_appointments_status()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
BEGIN
    -- Eğer randevu tarihi bugünden önceyse, status'u 'geçmiş' olarak ayarla
    IF NEW.appointment_date < CURRENT_DATE THEN
        NEW.status := 'geçmiş';
    END IF;
    RETURN NEW; -- Değiştirilen NEW kaydını döndür
END;
$function$
;

create function add_patient 
BEGIN
    INSERT INTO patient (first_name,gender ,last_name)
    VALUES (p_first_name,p_gender , p_last_name);
END;

create function assign_patient_to_doctor 
BEGIN
    INSERT INTO doctor_patient(doctor_id, patient_id)
    VALUES (p_doctor_id,p_patient_id);
END;

create function delete_appointment 
    BEGIN
        DELETE FROM appointment
        WHERE appointment_id=p_appointment_id;

    END;

create function update_patient 
BEGIN
    UPDATE patient SET first_name=p_name, last_name=p_surname, gender=p_gender WHERE id=p_id;
END;

