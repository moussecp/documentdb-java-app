create database scenario;

create table if not exists scenario.SCENARIO (
  SCENARIO_ID       INT AUTO_INCREMENT,
  NAME              VARCHAR(255),
  AUTHOR            VARCHAR(255),
  CREATION_DATE     DATETIME,
  FK_SCENARIO_STEPS NUMERIC,
  PRIMARY KEY (SCENARIO_ID)
);

create table if not exists scenario.SCENARIO_STEP (
  SCENARIO_STEP_ID    INT AUTO_INCREMENT,
  ACTION              VARCHAR(255),
  ACTION_TRIGGER_TIME INT,
  PRIMARY KEY (SCENARIO_STEP_ID)
);
