node {
	stage ('SCM checkout') {
		git "https://github.com/keflinrosa/ui-java-selenium"
	}

	stage ('Build') {
	   sh "mvn clean install"
    }

    stage ('Test') {
    	   sh "mvn test"
    }
}