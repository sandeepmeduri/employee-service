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
   	  steps{
   	    def mavenHome= tool 'M3'
		sh "${mavenHome}/bin/mvn clean package -Dmaven.test.skip=true"
        stash 'workspace'
      }
    } 

  } catch (def e) {
      print "Exception occurred while running the pipeline"+ e
  } finally {
      deleteDir()
  }
}
