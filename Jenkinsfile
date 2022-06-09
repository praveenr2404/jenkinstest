pipeline {
    agent any
    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'testId', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    bat '''
                        echo uname=%USERNAME% pwd=%PASSWORD%
                    '''
                    def uname = "%USERNAME%"
                    def pwd = "%PASSWORD%"
                }
                bat '''
                    echo "PATH = %PATH%"
                    echo "JAVA_HOME =%JAVA_HOME%"
                    echo "MAVEN_HOME = %MAVEN_HOME%"
                    echo uname=%testId.USERNAME% pwd=%testId.PASSWORD%
                '''
            }
        }

        stage ('Build') {
            steps {
                bat 'mvn install '+
                'exec:java '
            }
        }
        stage('Post build commit'){
            steps{
                bat '''
                    git commit -am "Add text"
                    git push origin HEAD:master --force
                '''
            }
        }
    }
}