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
                git branch: 'testing', credentialsId: 'git-cred', url: 'git@github.com:amisham96/caption-final-project.git'
            }
        }
     stage('Checkstyle') {
            steps {
                sh 'mvn checkstyle:checkstyle'
            }
        }
        stage('Checkstyle Report') {
            steps {
                recordIssues(tools: [checkStyle(pattern: 'target/checkstyle-result.xml')])
            }
        }
        stage('Code Coverage') {
            steps {
                jacoco()
            }
        }
        stage('SonarQube Analysis'){
            steps{
                dir("/var/lib/jenkins/workspace/final-caption-project"){
                withSonarQubeEnv('sonarqube'){
                    sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=candyshopapp -Dsonar.host.url=http://20.124.219.18:9000 -Dsonar.login=sqa_13948fa3dc8e6a0a9cbe053c03ed15558ca2f3b6'
                }
                }
            }
        }
        stage("Quality Gate"){
            steps{
                script{
                timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
                def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
                if (qg.status != 'OK') {
                    error "Pipeline aborted due to quality gate failure: ${qg.status}"
                }
                }
            }
            }
        }
       stage ('Upload jar to Nexus repository'){
          steps {
          nexusArtifactUploader(
          nexusVersion: 'nexus3',
          protocol: 'http',
          nexusUrl: '20.85.225.255:8081',
          groupId: 'candyshopapp',
          version: '0.0.1-SNAPSHOT',
          repository: 'maven-snapshots',
          credentialsId: 'nexus-cred',
          artifacts: [
            [artifactId: 'candyshopapp',
             classifier: '',
             file: 'target/candyshop-0.0.1-SNAPSHOT.jar',
             type: 'jar']
        ]
        )
        }
     }
    }
}
