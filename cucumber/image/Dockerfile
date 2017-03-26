FROM usmar-docker-registry01.us.oracle.com/ocpm-cucumber-driver:1.3.6
MAINTAINER cv.raidinesh@gmail.com
LABEL Description="Cucumber test driver for the container example" version="BUILD_REPLACE_VERSION"
#
# Use pip to install any additional packages
# N/A for this component
# Now use COPY to lay down any required libraries into /robot/lib
# N/A for this component
#
RUN gem install ocpm_spring_helper:0.1.1
# Now use COPY to lay down any required tests into /test
COPY features /test/features

# Now lay down the expected entry point /test/runTests.sh. This MUST output results into /var/www/html/testResults
COPY runTests.sh /test/runTests.sh