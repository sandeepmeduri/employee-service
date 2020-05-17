#!groovy
def javaAgent = 'docker-slave'
def branch
def projectName = 'mylibrary-book-service'
def gitCredentials = 'mylibrary-github'

node(javaAgent) {
  try {
    stage('Collect info') {
      checkout scm
      branch = env.BRANCH_NAME
    }

    stage('Build') {
      tools {
        maven 'M3'
   	  }
   	  steps{
		sh "mvn clean package -Dmaven.test.skip=true"
        stash 'workspace'
      }
    } 

  } catch (def e) {
      print "Exception occurred while running the pipeline"+ e
  } finally {
      deleteDir()
  }
}
