#!/bin/bash

function db_usage {
  echo "Usage: database $1 [OPTIONS]"
  echo ""
  echo "Options:"
  echo "  -h,  --help       Usage information"
  echo "  -u,  --update     Update database"
  echo "  -d,  --drop       Drop all database tables"
  echo ""
}

function db_update {
  echo "Updating database..."

  # Get a list of all the modules of the Maven project
  MODULES=$(mvn help:evaluate -Dexpression=project.modules -q -DforceStdout | grep -v '\[' | sed 's/<[^>]*>//g')

  # Iterate over each module with "spi" prefix and perform some action
  for module in $MODULES
  do
      if [[ $module == spi* ]]
      then
          echo "Processing module: $module"
          mvn -pl "$module" liquibase:update
      fi
  done
}

function db_drop {
  echo "Drop all database tables..."

  # Get a list of all the modules of the Maven project
  MODULES=$(mvn help:evaluate -Dexpression=project.modules -q -DforceStdout | grep -v '\[' | sed 's/<[^>]*>//g')

  # Iterate over each module with "spi" prefix and perform some action
  for module in $MODULES
  do
      if [[ $module == spi* ]]
      then
          echo "Processing module: $module"
          mvn -pl "$module" liquibase:dropAll
      fi
  done
}

function database {
  case $1 in
    -h|--help) db_usage "$1"; exit 0;;
    -u|--update) db_update;;
    -d|--drop) db_drop;;
    *) echo "Unknown parameter passed: $1"; exit 1;;
  esac
}