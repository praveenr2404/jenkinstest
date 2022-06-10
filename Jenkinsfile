/*def batch =[:]
withCredentials([usernamePassword(credentialsId: 'testId', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
    bat '''
        echo uname=%USERNAME% pwd=%PASSWORD%
    '''
    batch.uname = "%USERNAME%"
    batch.pwd = "%PASSWORD%"
}*/

pipeline {
    agent any
    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk8'
    }
    environment{
        Test_ID =credentials('testId')
    }
    stages {
        stage ('Initialize') {
            steps {
                bat '''
                    echo "PATH = %PATH%"
                    echo "JAVA_HOME =%JAVA_HOME%"
                    echo "MAVEN_HOME = %MAVEN_HOME%"
                    echo uname=%testId.USERNAME% pwd=%testId.PASSWORD%
                '''
                withCredentials([usernamePassword(credentialsId: 'testId', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    bat '''
                        echo uname=%USERNAME% pwd=%PASSWORD%
                    '''
                }
            }
        }

        stage ('Build') {
            steps {
                bat 'mvn '+
                'exec:java -Duser=%Test_ID_USR% -Dpwd="%Test_ID_PSW%"'
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