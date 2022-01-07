#!/usr/bin/env bash
#
# Sample usage:
#
#   TBD
#
echo "stop discovery-service"
docker stop discovery-service

echo "remove discovery-service"
docker rm discovery-service

echo "discovery-service is removed from docker"
