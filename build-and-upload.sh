#!/usr/bin/env bash
# Run this on the development machine in the directory where it is.
sbt dist
scp -i ~/.ssh/mashtapp_rsa target/universal/mashtapp-api-1.0-SNAPSHOT.zip mashtapp@157.230.47.167:~
