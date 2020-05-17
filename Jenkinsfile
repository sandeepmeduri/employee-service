#!groovy
  def branch = 'master'
  def projectName = 'employee-service'
  
pipeline {
	agent { label 'docker-slave' }
	tools {
         maven 'M3'
    }
	stages {
	  stage ('Collect info') {
		steps{
		  checkout scm
	      branch = ${BRANCH_NAME}
		}
	  }	
	  stage ('Build') {
		steps{
		  sh "mvn clean package -Dmaven.test.skip=true"
	      stash 'workspace'
		}
	  }
	}
}