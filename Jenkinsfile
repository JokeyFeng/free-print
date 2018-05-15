pipeline {
    agent any
    stages {
        stage('Check Out') {
            steps {                
             git branch: 'master', credentialsId: '9c730521-e897-41c2-9d0f-1c4a50919c49', url: 'https://github.com/JokeyFeng/free-print.git'
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
                docker rm -f print-server
                docker rmi print-server:1.0
                cd /root/.jenkins/workspace/移动打印/print-server/target/
                docker build -t print-server:1.0 -f /root/.jenkins/workspace/移动打印/print-server/Dockerfile /root/.jenkins/workspace/移动打印/print-server
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
