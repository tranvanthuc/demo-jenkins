

def test() {
    try {
        sh 'yarn'
    } catch (e) {
        echo 'Test failed'
        sh 'exit 1'
    }
}

def build() {
    try {
        echo 'Building...'
        // sh 'CI=false yarn build'
        withCredentials([usernamePassword(credentialsId: 'thuctv_github', usernameVariable: USER, passwordVariable: PWD)]) {
            echo "${USER} - ${PWD}"
        }
    } catch (e) {
        echo 'Build failed'
        sh 'exit 1'
    }
}

def deploy() {
    try {
        echo 'Deploying...'
    } catch (e) {
        echo 'Deploy failed'
        sh 'exit 1'
    }
}

return this