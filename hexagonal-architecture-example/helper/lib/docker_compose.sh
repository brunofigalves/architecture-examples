#!/bin/bash

function docker_usage {
  echo "Usage: docker $1 [OPTIONS]"
  echo ""
  echo "Options:"
  echo "  -h,  --help         Usage information"
  echo "  -d,  --deploy       Deploy application stack"
  echo "  -un, --undeploy     Undeploy application stack"
  echo ""
}

function docker_deploy {
  echo "Deploying stack into Docker..."
  docker-compose -f helper/docker/docker-compose.yml up -d --build --remove-orphans
}

function docker_undeploy {
  echo "Undeploying stack from Docker..."
  docker-compose down
  docker-compose -f helper/docker/docker-compose.yml rm
}

function docker_compose {
  case $1 in
    -h|--help) docker_usage "$1"; exit 0;;
    -d|--deploy) docker_deploy;;
    -un|--undeploy) docker_undeploy;;
    *) echo "Unknown parameter passed: $1"; exit 1;;
  esac
}
