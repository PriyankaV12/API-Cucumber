pipeline {
    agent any
    tools {
        maven '3.9.1'
    }

    stages {

        stage ('Checkout'){
            steps{
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[
                        url: 'https://github.com/PriyankaV12/API-Cucumber.git/',

                    ]]
                ])
            }
        }
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"

                '''
            }
        }

        stage('Download ChromeDriver') {
            steps {
                sh "curl -o chromedriver_mac64.zip https://chromedriver.storage.googleapis.com/112.0.5615.49/chromedriver_mac64.zip"
                sh "unzip -o ./chromedriver_mac64.zip -d ./"
                sh "chmod +x ./chromedriver"
            }
        }

        stage('Create data.yaml') {

            environment{
                key = credentials('key')
                value = credentials('value')
                url = credentials('baseURI')
                address = credentials('address')


            }

                steps {

                // Create data.yaml file
                sh 'touch src/main/java/POJO/data.yaml'
                // Add values to data.yaml
                sh 'echo "baseURI:  $url" > src/main/java/POJO/data.yaml'
                sh 'echo "queryKey: $key" >> src/main/java/POJO/data.yaml'
                sh 'echo "queryValue: $value" >> src/main/java/POJO/data.yaml'
                sh 'echo "address: $address" >> src/main/java/POJO/data.yaml'

            }
        }

         stage ('Run Tests') {
            steps {
                sh 'ls -al'
                sh 'mvn test'

            }

        }
    }
}