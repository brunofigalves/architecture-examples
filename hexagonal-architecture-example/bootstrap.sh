#!/bin/bash

source helper/lib/liquibase.sh
source helper/lib/k8s.sh
source helper/lib/docker_compose.sh

function usage {
  echo "Usage: $0 [options]"
  echo ""
  echo "Options:"
  echo "  -h,  --help               Usage information"
  echo "  -cp, --compile            Compile the project"
  echo "  -p,  --package MODE       Package the application using JVM, NATIVE or FAST-JAR mode"
  echo "  -c,  --clean              Clean generated files"
  echo ""
  echo "Management Commands:"
  echo "  database  Manage Liquibase"
  echo "  docker    Manage Docker"
  echo "  k8s       Manage K8s"
}

function compile {
  echo "Compiling..."
  mvn clean compile
}

function package {
  echo "Service packaging..."
  case "$1" in
  "jvm")
    echo "Packaging service using jvm mode"
    ./launcher-quarkus/mvnw clean package -DskipTests
    ;;
  "native")
    echo "Packaging service using native mode"
    cd launcher-quarkus && ./mvnw clean package -Pnative -Dquarkus.native.container-build=true -DskipTests ; cd ..
    ;;
  "fast-jar")
    echo "Packaging service using fast-jar mode"
    echo "Not supported yet"
    ;;
  esac
}

function clean {
  echo "Cleaning..."
  mvn clean
}

function main {
  case $1 in
    -h|--help) usage; exit 0;;
    -cp|--compile) compile;;
    -p|--package) package "$2";;
    -c|--clean) clean;;

    # Management commands
    database) database "$2";;
    docker) docker_compose "$2";;
    k8s) k8s "$2";;

    *) echo "Unknown parameter passed: $1"; exit 1;;
  esac
}

main "$@"
