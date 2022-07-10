pipeline {
    agent any
    environment{
        imageName = 'a30sham/candyshopapp'
        registryCredential = 'mydockercred'
        dockerImage = ''
    }
    tools {
        //install the maven version configured as m2 and add it to the path
        maven "maven"
    }
    stages {
        stage('Pull From SCM') {
            steps {
                git branch: 'prod', credentialsId: 'git-cred', url: 'git@github.com:amisham96/caption-final-project.git'
            }
        }
    stage('Building Docker image of the project'){
        steps{
            echo 'Starting to build docker image'
            script{
                dockerImage = docker.build imageName
            }
        }
     }
     stage('Deploy Image to Dockerhub Repository'){
         steps{
             script{
                 docker.withRegistry('', registryCredential) {
                     dockerImage.push()
                 }
             }
         }
     }
     stage('Deploy aks with terraform') {
            steps {
                script {
                    withCredentials([azureServicePrincipal(credentialsId: 'azure-cred', subscriptionIdVariable: 'SUBS_ID', clientIdVariable: 'CLIENT_ID', clientSecretVariable: 'CLIENT_SECRET', tenantIdVariable: 'TENANT_ID')]) {
                         sh 'az login --service-principal -u $CLIENT_ID -p $CLIENT_SECRET -t $TENANT_ID'
                         sh 'terraform init'
                         sh 'terraform plan -var client_id=$CLIENT_ID -var client_secret=$CLIENT_SECRET -var subs_id=$SUBS_ID -var tenant_id=$TENANT_ID'
                         sh 'terraform apply --auto-approve -var client_id=$CLIENT_ID -var client_secret=$CLIENT_SECRET -var subs_id=$SUBS_ID -var tenant_id=$TENANT_ID'
                    }
                }
            }
        }
      stage('Deploy Application to aks') {
            steps {
                script {
                        kubeconfig(credentialsId: 'k8s-cred1', serverUrl: 'https://aks-k8s-dns-f788ff08.hcp.eastus.azmk8s.io:443') {
                        sh 'kubectl apply -f mysql-cred.yml'    
                        sh 'kubectl apply -f mysql-root-cred.yml'
                        sh 'kubectl apply -f mysql-configmap.yml'
                        sh 'kubectl apply -f mysql-deployment.yml'
                        sh 'kubectl apply -f app-deployment.yml'
                    }
                }
            }
        }
         
    }
}
