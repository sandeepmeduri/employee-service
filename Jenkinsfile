#!groovy
def javaAgent = 'docker-slave'
def branch
def projectName = 'Infy-employee-service'

node(javaAgent) {
  try {
    stage('Collect info') {
      checkout scm
      branch = env.BRANCH_NAME
    }

    stage('Build') {
   	  def mavenHome= tool 'M3'
	  sh "${mavenHome}/bin/mvn clean package -Dmaven.test.skip=true"
    } 
    stage('Dockerize') {
      final String activeContainers = sh(script: "sudo docker ps -a", returnStdout: true)
	  boolean containerFound = activeContainers.toLowerCase().contains("${projectName}")
	  if (containerFound) {
	    sh "sudo docker stop ${projectName}"
	    sh "sudo docker rm ${projectName}"
        }
      sh "sudo docker build -t ${projectName} ."
  	  sh "sudo docker run --restart=always --network=host --name=${projectName} -e CONFIG_SERVER_URI=http://${params.configServerIp}:8888 -td ${projectName}"
	}

  } catch (def e) {
      print "Exception occurred while running the pipeline"+ e
  } finally {
      deleteDir()
  }
}
