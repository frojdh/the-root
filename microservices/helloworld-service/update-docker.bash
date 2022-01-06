#!/usr/bin/env bash
#
# Sample usage:
#
#   TBD
#

echo "build hellowworld-service image"
./gradlew build

echo "build hellowworld-service image"
./gradlew bootBuildImage --imageName=alluminate/helloworld-service

echo "stop hellowworld-service"
docker stop helloworld-service

echo "remove hellowworld-service"
docker rm helloworld-service

echo "run hellowworld-service"
docker run -d -p 8001:8001 -e "SPRING_PROFILES_ACTIVE=docker,utv" --name helloworld-service alluminate/helloworld-service

echo "helloworld-service is updated in docker"
