#!/usr/bin/bash
#
# We need to make sure to set no_proxy.
export no_proxy=${SUT},usmar-docker-registry01.us.oracle.com
# All tests are in /test
# Cucumber seems to be pretty sensitive to what directory it is run out of.
cd /test
cucumber --format html --out /var/www/html/testResults/cucumber.html --format json_pretty --out /var/www/html/testResults/cucumber.json
