pipeline {
    agent any
    stages {
        stage('Check Out') {
            steps {                
             git branch: 'master', credentialsId: 'a3dfb935-bb74-4775-a138-bfbd4aaa6ecb', url: 'https://github.com/JokeyFeng/free-print.git'
            }        
        }
         stage('Build and Install') {
            steps {                
                sh 'mvn clean install package -Dmaven.test.skip=true'
            }        
        }
        stage('Docker build images') {
            steps {                
                sh """
                docker rm -f print-server | true
                docker rmi print-server:1.0 | true
                cd /root/.jenkins/workspace/free-print/print-server/target/
                docker build -t print-server:1.0 -f /root/.jenkins/workspace/free-print/print-server/Dockerfile /root/.jenkins/workspace/free-print/print-server
                """
            }        
        }        
        stage('Docker run') {
            steps {
                sh 'docker run -d -p 2897:2897 --name print-server --restart=always -v /logs/free-print/print-server/:/logs/print-server/ print-server:1.0'
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
