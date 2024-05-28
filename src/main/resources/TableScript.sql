--Sequences:
drop SEQUENCE PRODUCT_SEQUENCE;

CREATE SEQUENCE  "STARTCODING0TO1"."PRODUCT_SEQUENCE" MINVALUE 1 MAXVALUE 1000 INCREMENT BY 1 START WITH 1 CACHE 20 ORDER  CYCLE  NOKEEP  NOSCALE  GLOBAL ;

drop sequence USER_SEQUENCE;

CREATE SEQUENCE  "STARTCODING0TO1"."USER_SEQUENCE"  MINVALUE 1 MAXVALUE 1000 INCREMENT BY 1 START WITH 3 NOCACHE  ORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;

drop sequence ADDRESS_ID_SEQ;

CREATE SEQUENCE  "STARTCODING0TO1"."ADDRESS_ID_SEQ"  MINVALUE 1 MAXVALUE 1000 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
