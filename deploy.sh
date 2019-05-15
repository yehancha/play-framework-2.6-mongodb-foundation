!/usr/bin/env bash
# Run this on the server.
mv ~/mashtapp-api-1.0-SNAPSHOT.zip /opt/mashtapp-api/
cd /opt/mashtapp-api/
lsof -i :9000 | grep 9000 | while read c1 c2 c3; do echo $c2; done > RUNNING
kill `cat RUNNING` 2>/dev/null
rm RUNNING
rm -rf mashtapp-api-1.0-SNAPSHOT-back
mv mashtapp-api-1.0-SNAPSHOT mashtapp-api-1.0-SNAPSHOT-back 
unzip mashtapp-api-1.0-SNAPSHOT.zip
export APPLICATION_SECRET=changethistoyouractualsecret
./mashtapp-api-1.0-SNAPSHOT/bin/mashtapp-api &

echo ""
echo "========================================="
echo "You can exit the process safely by CTRL+C"
echo "========================================="
echo ""
