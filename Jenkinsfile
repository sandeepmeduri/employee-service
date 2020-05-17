#!groovy
  def javaAgent = 'docker-slave'
  def branch
  def projectName = 'employee-service'
  
  tools {
         maven 'M3'
      }	

	// pipeline
	node(javaAgent) {
	  
	  stages{	           
	   try {

	    stage('Collect info') {
	      checkout scm
	      branch = env.BRANCH_NAME
	    }	
	    stage('Build') {
		  sh "mvn clean package -Dmaven.test.skip=true"
	      stash 'workspace'
        }
	
	   } catch (def e) {
		print "Exception occurred while running the pipeline"+ e
	   } finally {
	   	deleteDir()
	   }
	  }
    }
