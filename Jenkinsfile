node {
    // Get Artifactory server instance, defined in the Artifactory Plugin administration page.
    def server = "myservername"
    // Create an Artifactory Maven instance.
    def rtMaven = "mvn clean package"
    def buildInfo
    stage("install"){
        sh "wget https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz"
        sh "tar xvzf apache-maven-3.6.3-bin.tar.gz"
        sh "apache-maven-3.6.3/bin/mvn -version"
    }
    stage('Clone sources') {
   // git url: 'https://github.globant.com/luis-delapena/hello-mvn.git'
	print "my checkout"
    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'userp-pass', url: 'https://github.com/berserkV/demo.git']]])
    sh "pwd"
    }
    stage('config') {
        // Tool name from Jenkins configuration
        print 'my server configs with ssh'
        sh "export PATH=$PATH:/var/jenkins_home/workspace/demo_pipeline/apache-maven-3.6.3/bin"
    }
    stage('Maven build') {
        sh "apache-maven-3.6.3/bin/mvn clean package -f /var/jenkins_home/workspace/demo_pipeline"
	    //sh 'echo "my compilation with maven"'
    }
    stage('Maven test') {
        print "my maven unit test"
        sh "apache-maven-3.6.3/bin/mvn test"
    }
}
