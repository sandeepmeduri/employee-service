#!groovy
	def javaAgent = 'docker-slave'
	def branch
	def projectName = 'employee-service'

		// pipeline
	    node(javaAgent) {
	    	           
	        try {
	        tools {
    maven 'M3'
  }
	            stage('Collect info') {
	                checkout scm
	                branch = env.BRANCH_NAME
	            }
	
	            stage('Build') {
					sh "mvn -DskipTests clean package"
	                stash 'workspace'
	            }
	
	        } catch (def e) {
				print "Exception occurred while running the pipeline"+ e
	        } finally {
	        	deleteDir()
	    	}
	    }
