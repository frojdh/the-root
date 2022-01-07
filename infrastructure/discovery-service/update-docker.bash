#!/usr/bin/env bash
#
# Sample usage:
#
#   TBD
#

echo "build discovery-service image"
./gradlew build

echo "build discovery-service image"
./gradlew bootBuildImage --imageName=alluminate/discovery-service

echo "stop discovery-service"
docker stop discovery-service

echo "remove discovery-service"
docker rm discovery-service

echo "run discovery-service"
docker run -d -p 8761:8761 -e "SPRING_PROFILES_ACTIVE=docker,utv" --name discovery-service alluminate/discovery-service

echo "discovery-service is updated in docker"
