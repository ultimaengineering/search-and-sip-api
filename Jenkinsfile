podTemplate(yaml: """
apiVersion: v1
kind: Pod
metadata:
  labels:
    some-label: builder
spec:
  containers:
  - name: application-container
    image: openjdk:14-alpine
    command:
    - cat
    tty: true
    volumeMounts:
    - mountPath: '/workspace/opt/app/shared/'
      name: sharedvolume
  - name: kaniko
    workingDir: /tmp/jenkins
    image: gcr.io/kaniko-project/executor:debug
    imagePullPolicy: Always
    capabilities:
      add: ["IPC_LOCK"]
    command:
    - /busybox/cat
    tty: true
    volumeMounts:
    - mountPath: '/workspace/opt/app/shared/'
      name: sharedvolume
  volumes:
      - name: sharedvolume
        emptyDir:
          medium: "Memory"
"""
) {
   node(POD_LABEL) {
    stage('Build and test') {
     checkout scm
     container('application-container') {
      sh 'chmod 777 gradlew'
      sh './gradlew clean build'
      sh 'cp build/libs/*.jar /workspace/opt/app/shared/app.jar'
      sh 'cp Dockerfile /workspace/opt/app/shared/'
     }
    }
    stage('Build with Kaniko') {
     environment {
      PATH = "/busybox:/kaniko:$PATH"
     }
      container(name: 'kaniko', shell: '/busybox/sh') {
       sh 'cp -r /workspace/opt/app/shared/* /workspace/'
       sh 'pwd'
       sh 'ulimit -n 10000'
       sh '/kaniko/executor -f Dockerfile --destination=docker.ultimaengineering.io/search-and-sip-api:${BRANCH_NAME}-${BUILD_NUMBER}'
      }
     }
   }
  }
