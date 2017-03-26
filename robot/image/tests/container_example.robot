# Copyright (C) 2016 Oracle and/or its affiliates.  All Rights Reserved.
#
# This file contains material that is confidential and proprietary
# to Oracle and/or its affiliates.  No part of this file may be reproduced
# or transmitted in any form or by any means, electronic or
# mechanical, for any purpose, without the express permission of
# Oracle and/or its affiliates.

[Documentation]   All QP applications expose certain common rest APIs. This covers the most basic one - applicationInfo.
... This will include the version, application name, build date, etc...
...

*** Settings ***
Library  requests   
Library  Collections
Resource  app_common.robot

*** Variables ***
# This would normally be inheirited.
${CONTAINER_EXAMPLE_HOSTNAME}	%{SUT}
${CONTAINER_EXAMPLE_PORT}	8120	


*** Keywords ***
VerifyValue
  [Arguments]  ${hostname}  ${port}   ${expected_value} 
  ${result} =    get    http://${hostname}:${port}/example/value
  log   "The query result to get the value " + ${result}
  Should Be Equal    ${result.status_code}    ${200}
  ${raw} =  Set Variable   ${result.json()}
  ${expectedInt}=  Convert To Integer   ${expected_value}
  Should Be Equal  ${raw}  ${expectedInt}

CallDoubleIt
  [Arguments]  ${hostname}  ${port}		${value}    
  ${result} =    post    http://${hostname}:${port}/example/doubleit/${value} 
  log   "The call to double it had result code " + ${result}
  Should Be Equal    ${result.status_code}    ${200}

*** Test Cases ***
Wait For Container Example Startup
  Wait For App Startup   ${CONTAINER_EXAMPLE_HOSTNAME}  ${CONTAINER_EXAMPLE_PORT}

Verify Container Example Health
  Check Application Health OK  ${CONTAINER_EXAMPLE_HOSTNAME}  ${CONTAINER_EXAMPLE_PORT}

Verify Application Name
  ${reportedName} =   Get Application Name  ${CONTAINER_EXAMPLE_HOSTNAME}  ${CONTAINER_EXAMPLE_PORT}
  Should Be Equal  ${reportedName}  ContainerExample

Verify Application Version
  ${reportedVersion} =  Get Application Version  ${CONTAINER_EXAMPLE_HOSTNAME}  ${CONTAINER_EXAMPLE_PORT}
  Should Be Equal  ${reportedVersion}  1.0.0

Verify Double Behavior
  CallDoubleIt  ${CONTAINER_EXAMPLE_HOSTNAME}  ${CONTAINER_EXAMPLE_PORT}   47 
  VerifyValue   ${CONTAINER_EXAMPLE_HOSTNAME}  ${CONTAINER_EXAMPLE_PORT}   94 

