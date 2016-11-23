unzip -o *.zip 
chmod 777 -R *.*
cd zabbix-sisyphus-1.0.0-SNAPSHOT
cp application.properties ./conf
nohup java -Xms1024m -Xmx1024m -XX:PermSize=512M -XX:MaxPermSize=1024m -Djava.awt.headless=true  -XX:SurvivorRatio=4 -XX:ParallelGCThreads=4 -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:CMSInitiatingOccupancyFraction=68 -Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Djmagick.systemclassloader=no -Djava.rmi.server.hostname=10.23.24.104 -classpath ".:classes:conf:lib/*" com.zabbix.sisyphus.QuickStartServer  >> quickstart.out 2>&1 &
tail -f  ./quickstart.out 