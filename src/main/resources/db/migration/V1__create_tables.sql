
/*
-- clean
drop table c_user;
drop table c_rent;
drop table c_book;
drop table c_book_type;
drop table c_list_value;
drop table c_store;
drop table c_address;
drop table schema_version;

*/


CREATE TABLE  c_address (
	addr_id               int not null,
	addr_street   varchar (300),
  addr_county   varchar (255),
  addr_postcode int ,

  addr_is_enabled       varchar (1) default 'F' not null,
  addr_created_by_id    int not null,
  addr_updated_by_id    int not null,
  addr_created_datetime timestamp default current_timestamp not null,
  addr_updated_datetime timestamp default current_timestamp not null,
  CONSTRAINT pk_addr primary key (addr_id)
);


CREATE TABLE  c_store (
	store_id               int not null,
	store_name             varchar (255),
	store_desc             varchar (3000),
  store_email            varchar (255),
  store_phone            varchar (20),
  store_addr_id          int,
  store_is_enabled       varchar (1) default 'F' not null,
  store_created_by_id    int not null,
  store_updated_by_id    int not null,
  store_created_datetime timestamp default current_timestamp not null,
  store_updated_datetime timestamp default current_timestamp not null,
  CONSTRAINT pk_store primary key (store_id)
);

ALTER TABLE c_store ADD CONSTRAINT fk_store_addr_id FOREIGN KEY (store_addr_id) REFERENCES c_address(addr_id);

CREATE TABLE c_list_value (
	lev_id int not null,
	lev_name varchar(255) not null,
	lev_is_enabled varchar (1) default 'F' not null,
  lev_created_by_id int not null,
  lev_updated_by_id int not null,
  lev_created_datetime timestamp default current_timestamp not null,
  lev_updated_datetime timestamp default current_timestamp not null,
    CONSTRAINT pk_lev primary key (lev_id)
);

CREATE TABLE c_book_type (
	boot_id int not null,
	boot_name varchar(255) not null,
	boot_ssn  varchar(25) not null,
	boot_released_datetime timestamp,
	boot_publ_lev_id int,
	boot_auth_lev_id int,
  boot_is_enabled varchar (1) default 'F' not null,
  boot_created_by_id int not null,
  boot_updated_by_id int not null,
  boot_created_datetime timestamp default current_timestamp not null,
  boot_updated_datetime timestamp default current_timestamp not null,
  CONSTRAINT pk_boot primary key (boot_id)
);

ALTER TABLE c_book_type ADD CONSTRAINT fk_boot_auth_lev_id FOREIGN KEY (boot_auth_lev_id) REFERENCES c_list_value(lev_id);
ALTER TABLE c_book_type ADD CONSTRAINT fk_boot_publ_lev_id FOREIGN KEY (boot_publ_lev_id) REFERENCES c_list_value(lev_id);

CREATE TABLE  c_book (
	book_id               int not null,
	book_store_id         int,
	book_boot_id          int not null,
	book_store_note       varchar (1000), -- note to write to find the book
	book_desc             varchar (1000),       -- description for admin
	book_exp_nr           int,
	book_rent_nr          timestamp,
  book_is_enabled       varchar (1) default 'F' not null,
  book_created_by_id    int not null,
  book_updated_by_id    int not null,
  book_created_datetime timestamp default current_timestamp not null,
  book_updated_datetime timestamp default current_timestamp not null,
  CONSTRAINT pk_book primary key (book_id)
);

ALTER TABLE c_book ADD CONSTRAINT fk_book_boot_id FOREIGN KEY (book_boot_id) REFERENCES c_book_type(boot_id);
ALTER TABLE c_book ADD CONSTRAINT fk_book_store_id FOREIGN KEY (book_store_id) REFERENCES c_store(store_id);


CREATE TABLE  c_user (
	user_id               int not null,
	user_password         varchar (255) not null,
	user_first_name       varchar (255) not null,
	user_last_name        varchar (255) not null,
	user_email            varchar (255) not null,
	user_mobile           varchar(20) ,
  user_addr_id          int,
	user_is_enabled       varchar (1) default 'F' not null,
  user_created_by_id    int not null,
  user_updated_by_id    int not null,
  user_created_datetime timestamp default current_timestamp not null,
  user_updated_datetime timestamp default current_timestamp not null,
  CONSTRAINT pk_user primary key (user_id)
);
ALTER TABLE c_user ADD CONSTRAINT fk_user_addr_id FOREIGN KEY (user_addr_id) REFERENCES c_address(addr_id);

CREATE TABLE  c_rent (
	rent_id               int not null,
	rent_user_id          int,
	rent_book_id          int,
	rent_start_datetime   timestamp default current_timestamp not null,
	rent_end_datetime     timestamp,
	rent_type             varchar(100) not null,
	rent_extend_nr        int,

  rent_is_enabled       varchar (1) default 'F' not null,
  rent_created_by_id    int not null,
  rent_updated_by_id    int not null,
  rent_created_datetime timestamp default current_timestamp not null,
  rent_updated_datetime timestamp default current_timestamp not null,
  CONSTRAINT pk_rent primary key (rent_id)
);
