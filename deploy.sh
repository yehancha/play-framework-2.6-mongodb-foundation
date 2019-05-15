!/usr/bin/env bash
# Run this on the server.
mv ~/mashtapp-api-1.0-SNAPSHOT.zip /opt/mashtapp-api/
cd /opt/mashtapp-api/
kill `cat mashtapp-api-1.0-SNAPSHOT/RUNNING_PID`
rm -rf mashtapp-api-1.0-SNAPSHOT-back
mv mashtapp-api-1.0-SNAPSHOT mashtapp-api-1.0-SNAPSHOT-back 
unzip mashtapp-api-1.0-SNAPSHOT.zip
export APPLICATION_SECRET=changethistoyouractualsecret
./mashtapp-api-1.0-SNAPSHOT/bin/mashtapp-api &
