@echo off

jarsigner -keystore ssRoundTableKey.bin -signedjar ss_axis.jar axis.jar sskey1

jarsigner -keystore ssRoundTableKey.bin -signedjar ss_commons-discovery-0.2.jar commons-discovery-0.2.jar sskey1

jarsigner -keystore ssRoundTableKey.bin -signedjar ss_commons-logging-1.0.4.jar commons-logging-1.0.4.jar sskey1

jarsigner -keystore ssRoundTableKey.bin -signedjar ss_forms-1.0.5.jar forms-1.0.5.jar sskey1

jarsigner -keystore ssRoundTableKey.bin -signedjar ss_jaxrpc.jar jaxrpc.jar sskey1

jarsigner -keystore ssRoundTableKey.bin -signedjar ss_log4j-1.2.8.jar log4j-1.2.8.jar sskey1

jarsigner -keystore ssRoundTableKey.bin -signedjar ss_looks-1.3.1.jar looks-1.3.1.jar sskey1

jarsigner -keystore ssRoundTableKey.bin -signedjar ss_ProjectServerAPI.jar ProjectServerAPI.jar sskey1

jarsigner -keystore ssRoundTableKey.bin -signedjar ss_saaj.jar saaj.jar sskey1

jarsigner -keystore ssRoundTableKey.bin -signedjar ss_SharedSchedulingClient.jar SharedSchedulingClient.jar sskey1

jarsigner -keystore ssRoundTableKey.bin -signedjar ss_wsdl4j-1.5.1.jar wsdl4j-1.5.1.jar sskey1



