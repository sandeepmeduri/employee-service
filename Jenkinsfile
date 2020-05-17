#!groovy
  def javaAgent = 'docker-slave'
  def branch
  def projectName = 'employee-service'
  
pipeline {
	agent any
	tools {
         maven 'M3'
    }
	stages {
		stage ('Collect info') {
		  checkout scm
	      branch = env.BRANCH_NAME
		}
		stage ('Build') {
		  sh "mvn clean package -Dmaven.test.skip=true"
	      stash 'workspace'
		}
	}
}