pipeline {
    agent any
    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                bat '''
                    echo "PATH = %PATH%"
                    echo "JAVA_HOME =%JAVA_HOME%"
                    echo "MAVEN_HOME = %MAVEN_HOME%"
                '''
            }
        }

        stage ('Build') {
            steps {
                bat 'mvn -Dmaven.test.failure.ignore=true install'
            }
        }
    }
}