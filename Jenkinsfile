pipeline {
    agent any
    stages {
        stage('Check Out') {
            steps {                
             git branch: 'master', credentialsId: '34bef64d-39ab-4f2f-af46-6f69ee6079a0', url: 'http://192.168.1.122:3000/JAVA/free-print.git'
            }        
        }        
        stage('Build and Install') {
            steps {                
                sh 'mvn clean install package -Dmaven.test.skip=true'
            }        
        }
        stage('Docker build images') {
            steps {                
                echo 'docker bilud'
            }        
        }        
        stage('Docker run') {
            steps {                
                echo 'running!'
            }        
        }
    }
 
    post {        
        always {
            echo 'One way or another, I have finished'
        }
        success {
            echo 'I succeeeded!'        
        }        
        unstable {
            echo 'I am unstable :/'        
        }        
        failure {
            echo 'I failed :('        
        }        
        changed {
            echo 'Things were different before...'        
        }    
    }
}