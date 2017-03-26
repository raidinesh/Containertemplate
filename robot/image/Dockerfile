FROM usmar-docker-registry01.us.oracle.com/ocpm-robot-driver:1.0.1
MAINTAINER cv.raidinesh@gmail.com
LABEL Description="Image for testing the ContainerExample container" version="BUILD_REPLACE_VERSION"
#
# Use pip to install any additional packages
# N/A for this component
# Now use COPY to lay down any required libraries into /test/lib
# N/A for this component
#

# Now use COPY to lay down any required tests into /test/
COPY tests/*.robot /test/tests/

# Now lay down the expected entry point /test/runTests.sh. This MUST output results into /var/www/html/testResults
COPY runTests.sh /test/runTests.sh
