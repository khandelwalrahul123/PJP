pipeline {
   agent any

   tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
      }


    triggers {
        cron('0 10 * * *')
    }

      stages {

            stage('Getting_Assignment'){         
              steps{
                  git branch: 'week1', url: 'https://github.com/khandelwalrahul123/PJP.git'
                  }
                }
            stage('Build') {
             steps {
              sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
              success {
               junit '**/target/surefire-reports/TEST-*.xml'
               archiveArtifacts 'target/*.jar'
             }
           }
         }
         stage('Run') {
         steps {
            sh "java -cp target/rahul_assignment-1.0-SNAPSHOT.jar assignment.week1.maven.HelloWorld"
            
         }
      }
      }
    }
