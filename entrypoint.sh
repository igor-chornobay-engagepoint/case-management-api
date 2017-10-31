#!/bin/bash

#The file should have UNIX-style EOL

if [ -z "$CM_API_CONFIG" ]
then
  CM_API_CONFIG="case-management-api.yml"
fi

echo "config file: $CM_API_CONFIG"


if [ -f /opt/newrelic/newrelic.yml ]; then
    java -javaagent:/opt/newrelic/newrelic.jar  ${JAVA_OPTS} -jar case-management-api.jar server $CM_API_CONFIG
else
    java  ${JAVA_OPTS} -jar case-management-api.jar server $CM_API_CONFIG
fi
