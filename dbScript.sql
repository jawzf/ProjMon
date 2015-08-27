--------------------------------------------------------
--  File created - Tuesday-August-25-2015   
--------------------------------------------------------
--------------------------------------------------------

--------------------------------------------------------
--  DDL for Table STATUSTABLE
--------------------------------------------------------

  CREATE TABLE "STATUSTABLE" 
   (	"EQUIPID" VARCHAR2(20), 
	"CUSTID" VARCHAR2(20), 
	"ADDRESS" VARCHAR2(60), 
	"EMAIL" VARCHAR2(30), 
	"STATUS" VARCHAR2(10)
   ) ;
--------------------------------------------------------
--  DDL for Table ASSIGNTABLE
--------------------------------------------------------

  CREATE TABLE "ASSIGNTABLE" 
   (	"EQUIPID" VARCHAR2(20) UNIQUE, 
	"TECHNICIANID" VARCHAR2(20)
   ) ;
--------------------------------------------------------
--  DDL for Table DOWNTABLE
--------------------------------------------------------

  CREATE TABLE "DOWNTABLE" 
   (	"EQUIPID" VARCHAR2(20), 
	"CUSTID" VARCHAR2(20), 
	"ADDRESS" VARCHAR2(60), 
	"EMAIL" VARCHAR2(30), 
	"STATUS" VARCHAR2(10)
   ) ;



  CREATE UNIQUE INDEX "SYS_C0011253" ON "STATUSTABLE" ("EQUIPID") 
  ;



