@echo off

java -cp ProjectServer.jar;derby.jar com.dommoni.roundtable.projectServer.utils.db.DBGenerator ./sql jdbc:derby:./db/core;create=true org.apache.derby.jdbc.EmbeddedDriver "" ""