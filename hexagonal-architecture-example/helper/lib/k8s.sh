#!/bin/bash

function k8s_usage {
  echo "Usage: k8s $1 [OPTIONS]"
  echo ""
  echo "Options:"
  echo "  -h,  --help         Usage information"
  echo "  -d,  --deploy       Deploy application stack"
  echo "  -un, --undeploy     Undeploy application stack"
  echo ""
}

function k8s_deploy {
  echo "Deploying stack into K8s..."

  kubectl create -f k8s/db-configmap.yml
  kubectl create -f k8s/db-storage.yml
  kubectl create -f k8s/db-deployment.yml
  kubectl create -f k8s/db-service.yml

  kubectl create -f k8s/app-configmap.yml
  kubectl create -f k8s/app-deployment.yml
  kubectl create -f k8s/app-service.yml
}

function k8s_undeploy {
  echo "Undeploying stack from K8s..."

  kubectl delete service sample-users-db-service
  kubectl delete deployment sample-users-db-deployment
  kubectl delete configmap sample-users-db-config
  kubectl delete persistentvolumeclaim sample-users-db-pv-claim
  kubectl delete persistentvolume sample-users-db-pv-volume

  kubectl delete service sample-users-app-service
  kubectl delete deployment sample-users-app-deployment
  kubectl delete configmap sample-users-app-config
}

function k8s {
  case $1 in
    -h|--help) k8s_usage "$1"; exit 0;;
    -d|--deploy) k8s_deploy;;
    -un|--undeploy) k8s_undeploy;;
    *) echo "Unknown parameter passed: $1"; exit 1;;
  esac
}
