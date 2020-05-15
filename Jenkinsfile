#!groovy
	def mvnHome = tool name: 'Apache Maven 3.6.0', type: 'maven'
	def javaAgent = 'openjdk'
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
					sh "${mvnHome}/bin/mvn -DskipTests clean package"
	                stash 'workspace'
	            }
	
	        } catch (def e) {
				print "Exception occurred while running the pipeline"+ e
	        } finally {
	        	deleteDir()
	    	}
	    }
