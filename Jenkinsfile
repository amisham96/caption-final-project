pipeline {
    agent any
    // agent is where my pipeline will be eexecuted
    tools {
        //install the maven version configured as m2 and add it to the path
        maven "maven"
    }
    stages {
        stage('Pull From SCM') {
            steps {
                git branch: 'dev', credentialsId: 'git-cred', url: 'git@github.com:amisham96/caption-final-project.git'
            }
        }
        stage('Run Maven Build') {
            steps {
            sh "mvn clean package"
            }
            post {
                //if maven build was able to run the test we will create a test report and archive the jar in local machine
                success {
                    junit '**/target/surefire-reports/*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
