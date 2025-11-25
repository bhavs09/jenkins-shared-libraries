def call(String Project, String ImageTag, String dockerUserFromParam){
    withCredentials([usernamePassword(credentialsId: 'dockerhubcred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        // Secure login
        sh """
            echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin
            docker push "$dockerHubUser/$Project:$ImageTag"
        """
    }
}
