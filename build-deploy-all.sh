USER=mcouck

# Gateways: sl01740v.ops.vdab.be sl01743v.ops.vdab.be sl01744v.ops.vdab.be
# sudo yum install java-1.8.0-openjdk.x86_64

APP=${PWD##*/}
for SERVER in "$@"
do
    ssh ${USER}@${SERVER} 'sudo rm /opt/gateway-server/nohup.out'
    scp target/${APP}-1.0.0.jar ${USER}@${SERVER}:/opt/${APP}
    ssh ${USER}@${SERVER} 'cd /opt/gateway-server; java -javaagent:/opt/elastic-apm-agent-1.1.0.jar -Delastic.apm.server_urls=http://sl01757v.ops.vdab.be:8200 -Delastic.apm.service_name=gateway -Delastic.apm.application_packages=org.springframework -Dspring.profiles.active=sand-box -jar gateway-server-1.0.0.jar >> nohup.out &' &
done