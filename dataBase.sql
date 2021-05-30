CREATE TABLE Adress (
  id bigint NOT NULL,
  country varchar(50) NOT NULL,
  town varchar(50) NOT NULL,
  street varchar(50) NOT NULL,
  house_number varchar(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Clients (
  rating float NOT NULL,
  contract_сount bigint NOT NULL,
  name varchar(50) NOT NULL,
  surname varchar(50) NOT NULL,
  client_id bigint NOT NULL,
  birth_date date DEFAULT NULL,
  PRIMARY KEY (client_id)
);

CREATE TABLE Drivers (
  driver_id bigint NOT NULL,
  gender varchar(1) NOT NULL,
  start_working_date date NOT NULL,
  birth_date date NOT NULL,
  PRIMARY KEY (driver_id)
);

CREATE TABLE Models (
  id bigint NOT NULL,
  mark varchar(50) NOT NULL,
  generation varchar(50) NOT NULL,
  model varchar(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE AutoHouses (
  id bigint NOT NULL,
  adress_id bigint NOT NULL,
  start_work date NOT NULL,
  end_work date NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT AutoHouses_adress_id_Adress_id_foreign FOREIGN KEY (adress_id) REFERENCES Adress (id)
);

CREATE TABLE promotions (
  id bigserial NOT NULL,
  start_date date NOT NULL,
  end_date date NOT NULL,
  promotion integer NOT NULL,
  model_id integer NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT promotions_model_id_Models_id_foreign FOREIGN KEY (model_id) REFERENCES Models (id)
);

CREATE TABLE Cars (
  id bigint NOT NULL,
  model_id bigint NOT NULL,
  buy_date date NOT NULL,
  rented boolean NOT NULL,
  produced_date data NOT NULL,
  sits_count integer NOT NULL,
  body_type varchar(50) NOT NULL,
  fuel_consumption integer NOT NULL,
  transmission varchar(1) NOT NULL,
  autohouse_id bigint NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT Cars_autohouse_id_AutoHouses_id_foreign FOREIGN KEY (autohouse_id) REFERENCES AutoHouses (id),
  CONSTRAINT Cars_model_id_Models_id_foreign FOREIGN KEY (model_id) REFERENCES Models (id)
);

CREATE TABLE Price (
  car_id integer NOT NULL,
  start_price integer NOT NULL,
  profitability_coeff integer NOT NULL,
  amortization_coeff integer NOT NULL,
  id bigint NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT Price_car_id_Cars_id_foreign FOREIGN KEY (car_id) REFERENCES Cars (id)
);

CREATE TABLE Contract (
  id serial NOT NULL,
  car_id integer NOT NULL,
  client_id integer NOT NULL,
  date_start date NOT NULL,
  date_end date NOT NULL,
  auto_house_id bigint NOT NULL,
  driver_id bigint DEFAULT NULL,
  is_active boolean NOT NULL,
  promotion_id bigint NOT NULL,
  price_id bigint NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT Contract_car_id_Cars_id_foreign FOREIGN KEY (car_id) REFERENCES Cars (id),
  CONSTRAINT Contract_auto_house_id_AutoHouses_id_foreign FOREIGN KEY (auto_house_id) REFERENCES AutoHouses (id),
  CONSTRAINT Contract_driver_id_Drivers_driver_id_foreign FOREIGN KEY (driver_id) REFERENCES Drivers (driver_id),
  CONSTRAINT Contract_client_id_Clients_client_id_foreign FOREIGN KEY (client_id) REFERENCES Clients (client_id),
  CONSTRAINT Contract_promotion_id_promotions_id_foreign FOREIGN KEY (promotion_id) REFERENCES promotions (id),
  CONSTRAINT Contract_price_id_Price_id_foreign FOREIGN KEY (price_id) REFERENCES Price (id)
);