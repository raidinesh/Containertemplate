# Copyright (C) 2016 Oracle and/or its affiliates.  All Rights Reserved.
#
# This file contains material that is confidential and proprietary
# to Oracle and/or its affiliates.  No part of this file may be reproduced
# or transmitted in any form or by any means, electronic or
# mechanical, for any purpose, without the express permission of
# Oracle and/or its affiliates.

[Documentation]   All QP applications expose certain common rest APIs.
... ApplicationInfo - This will include the version, application name, build date, etc...
... Health - Simple methods to check health

*** Settings ***
Library  requests   
Library  Collections

*** Keywords ***
Wait For App Startup
    [Arguments]	  ${hostname}	  ${port}	
    # Test if GlassFish is fully started, checking every 10 seconds and giving up after 5 minutes.
    Wait Until Keyword Succeeds    5 min    10 sec    Check Application Health OK   ${hostname}	  ${port}	

Get Application Info Variable
  [Arguments]	${hostname}	${port}		${app_var_name}
  ${result} =    get    http://${hostname}:${port}/info
  log   "The app info http code was " + ${result.status_code}
  Should Be Equal    ${result.status_code}    ${200}
  ${json} =  Set Variable   ${result.json()}
  ${dictionaryValue} =  Get From Dictionary  ${json}  ${app_var_name} 
  [return]   ${dictionaryValue}

Get Application Name
  [Arguments]	${hostname}	${port}	
  ${result} =   Get Application Info Variable	${hostname}	${port}		app_name
  [return]   ${result}

Get Application Version
  [Arguments]	${hostname}	${port}	
  ${result} =   Get Application Info Variable	${hostname}	${port}		app_version
  [return]   ${result}

Get Application Health
  [Arguments]	${hostname}	${port}	
  ${result} =    get    http://${hostname}:${port}/health/
  log   "The health http code was " + ${result.status_code}
  Should Be Equal    ${result.status_code}    ${200}
  ${json} =  Set Variable   ${result.json()}
  ${dictionaryValue} =  Get From Dictionary  ${json}  status 
  log   "The health result was " + ${dictionaryValue}
  [return]   ${dictionaryValue}

Check Application Health OK
  [Arguments]	${hostname}	${port}	
  ${result} =  Get Application Health  ${hostname}	${port}	
  Should Be Equal    ${result}    UP
  



  
