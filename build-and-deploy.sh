#!/usr/bin/env bash

# Exit if one command  fails
set -e 

# Stos current running and all proceeding commands in the script if CTRL+C
trap "exit" INT

# First, we build locally and upload.

sbt dist
scp -i ~/.ssh/mashtapp_rsa target/universal/mashtapp-api-1.0-SNAPSHOT.zip mashtapp@157.230.47.167:~

# Then we run the deploy script on the server.

ssh -i ~/.ssh/mashtapp_rsa mashtapp@157.230.47.167 'bash -s' < deploy.sh
