#!/usr/bin/bash
#
# We need to make sure to set no_proxy. 
#export no_proxy=${SUT},usmar-docker-registry01.us.oracle.com
# All tests are in /test/tests, all libs are in /test/lib
robot -d /var/www/html/testResults /test/tests/
