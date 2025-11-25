def call(String Project, String ImageTag, String dockerUserFromParam){
  withCredentials([usernamePassword(credentialsId: 'dockerhubcred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]){
    sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  }
  sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
