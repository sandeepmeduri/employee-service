#!groovy
  def javaAgent = 'docker-slave'
  def branch
  def projectName = 'employee-service'

	// pipeline
	node(javaAgent) {	
	  	           
	  try {

	    stage('Collect info') {
	      checkout scm
	      branch = env.BRANCH_NAME
	    }	
	    stage('Build') {
		  sh "mvn mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.skip=true"
	      stash 'workspace'
        }
	
	  } catch (def e) {
		print "Exception occurred while running the pipeline"+ e
	  } finally {
	   	deleteDir()
	  }
	  
    }
