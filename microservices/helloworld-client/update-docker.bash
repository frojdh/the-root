#!/usr/bin/env bash
#
# Sample usage:
#
#   TBD
#

echo "build hellowworld-client"
ng build

echo "build hellowworld-client image"
docker build -t alluminate/helloworld-client .

echo "stop hellowworld-client"
docker stop helloworld-client

echo "remove hellowworld-client"
docker rm helloworld-client

echo "run hellowworld-client"
docker run -d -p 4200:4200 --name helloworld-client alluminate/helloworld-client

echo "helloworld-client is updated in docker"
