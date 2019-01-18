USER=mcouck

# Gateways: sl01740v.ops.vdab.be sl01743v.ops.vdab.be sl01744v.ops.vdab.be
# sudo yum install java-1.8.0-openjdk.x86_64

APP=${PWD##*/}
for SERVER in "$@"
do
    # echo Deploying to "$SERVER", killing app "$APP"
    # ssh-copy-id -i ~/.ssh/id_rsa.pub mcouck@$SERVER
    # sleep 1

    ssh $USER@$SERVER 'sudo pkill -9 -f java'

    # Deploy the certificate
    scp C:/etc/ssl/certs/vdab.jks $USER@$SERVER:/etc/ssl/certs

    # Deploy the application
    ssh $USER@$SERVER 'sudo chmod 777 /etc/ssl/certs/vdab.jks; sudo mkdir -p /opt/gateway-server'
    scp target/$APP-1.0.0.jar $USER@$SERVER:/opt/$APP
    ssh $USER@$SERVER 'sudo chmod 777 /opt/gateway-server/*; rm /opt/gateway-server/nohup.out'
    ssh $USER@$SERVER 'cd /opt/gateway-server; java \
        -Djavax.net.ssl.keyStore=/etc/ssl/certs/vdab.jks \
        -Djavax.net.ssl.keyStorePassword=3DHpdKDFVafErV7X \
        -Djavax.net.ssl.trustStore=/etc/ssl/certs/vdab.jks \
        -Djavax.net.ssl.trustStorePassword=3DHpdKDFVafErV7X \
        -jar -Dspring.profiles.active=sand-box gateway-server-1.0.0.jar >> nohup.out &' &
done