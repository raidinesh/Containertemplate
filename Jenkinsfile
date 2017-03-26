// Note, MOST people should never alter the function definitions. They can skip down to the call to 'wrappedPipeline'
//---------------------------------------------------------------------
// +++chris need to parameterize the ES host
env.ELASTICSEARCH_IP = "10.148.233.29"
env.EXECUTION_ID=env.BUILD_TAG
env.NODE_LABEL='CHRIS'

def utils = fileLoader.fromGit('src/cgbu/ocpm/JenkinsfileUtils',
			       'http://usmar-gitlab01.us.oracle.com:81/ming.lu/pipeline-shared-libs.git',
			       'release_0.1.0',
			       'null',
			       '')


//---------------------------------------------------------------------
// Most people should only edit things below
utils.wrappedPipeline {
  utils.checkout('http://usmar-gitlab01.us.oracle.com:81/template/container.git', 'f9dd9169-e5a1-4c35-a4f7-2d329854a49b')

  stage 'Update License Headers'
  echo 'Update License Headers (if develop branch)'
  //sh './gradlew licenseFormat'

  utils.buildProject()
  
  utils.runJunit()

  utils.archiveJacocoResults()
  
  utils.buildDockerImages()

  utils.executeRobot('robot/topology', '5','2')

  utils.executeCucumber('cucumber/topology', '45', '2')

  utils.executeSonarQube()
  
  utils.publishContainerImages()

  // Cleanup the latest
  echo 'Cleanup Container Images.'
  sh './gradlew cleanDockerImages'

} // End of wrappedPipeline
