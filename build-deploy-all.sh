USER=mcouck

# Gateways: sl01740v.ops.vdab.be sl01743v.ops.vdab.be sl01744v.ops.vdab.be

mvn clean install

APP=${PWD##*/}
for SERVER in "$@"
do
    echo Deploying to "$SERVER", killing app "$APP"
    ssh $USER@$SERVER 'ps -ef | grep java'
    ssh $USER@$SERVER 'sudo pkill -9 -f java'

    # Deploy the certificate
    ssh $USER@$SERVER 'sudo touch /etc/ssl/certs/vdab.jks; sudo chmod 777 /etc/ssl/certs/vdab.jks'
    scp src/main/resources/trash/vdab.jks $USER@$SERVER:/etc/ssl/certs
    ssh $USER@$SERVER 'sudo chmod 777 /etc/ssl/certs/vdab.jks'

    # Deploy the application
    ssh $USER@$SERVER 'sudo mkdir -p /opt/gateway-server; sudo chmod 777 -R /opt/gateway-server'
    ssh $USER@$SERVER 'sudo chmod 777 -R /opt/gateway-server'
    scp target/$APP-1.0.0.jar $USER@$SERVER:/opt/$APP
    ssh $USER@$SERVER 'sudo chmod 777 /opt/gateway-server/*; sudo rm /opt/gateway-server/nohup; ls -lh /opt/gateway-server'
    ssh $USER@$SERVER 'cd /opt/gateway-server; java -jar -Dspring.profiles.active=sand-box gateway-server-1.0.0.jar >> nohup &' &
done