./gradlew bootRun
docker images
./gradlew jibDockerBuild
docker images
docker push upmce-docker-local-v2.jfrog.io/myupmc/xray-demo

localhost:8080/demo

kubectl apply combination and xray-service