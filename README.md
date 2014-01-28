
Android Push Notifications
==========================

This is a android push notification examples using JAVA or PHP or NodeJS server 

All of these cases we need use google cloud messaging (GCM) application. 
Because our own server can't send push notifications to android device. So we need to setup GCM app and request that GCM app to push notifications to android client application

Create google cloud messaging (GCM) application
===============================================

 1. For this case you can follow the instruction in following link to creat GCM project as an application in google cloud.
    (http://developer.android.com/google/gcm/gs.html)
    * Make sure that you need to create keys for both android client and server client.
    * You can create keys
      Public API access -> create new key
    * When you create key for server application, don't add IPs for it. Just create. If you add IPs, those key is authorized only to those IPs

JAVA Example projects
=====================

 For this example I used PushNotificationApp (https://cloud.google.com/console/project) from kavi707 google account

 * Java Server
   -----------
     1. In this commited code, you need to add the API key you generated in GCM application (server key) to this java server
     2. Build the project. Its an ant build, use following command
            ant war
     3. Deploy the built .war file in web server like apache-tomcat
     4. Access the application from browser http://<your machine ip>:<tomcat port>/gcm-demo

 * Android client
   --------------
     1. Edit the src/com/google/android/gcm/demo/app/CommonUtils.java class
           Add your java server url to SERVER_URL parameter
           Add GCM project number as SENDER_ID
     2. Build the application and install it on android device or emulator

PHP Example project
===================

 * PHP Server
   ----------
     1. Edit the config.php file, and add the mysql database configurations into that.
     2. Same file (config.php) add the Google server API key to GOOGLE_API_KEY parameter
     3. Deploy the application in apache web server

 * Android client
   --------------
     1. Edit the app/src/main/java/com/androidexample/gcm/Config.java class
           Add your php server application url to YOUR_SERVER_URL parameter
           Add GCM project number as GOOGLE_SENDER_ID
     2. Build the application and install it on android device or emulator

NodeJS Example project
======================

 * NodeJS app to send requests to GCM
   ----------------------------------
     1. Edit app.js, and add GCM server application key as parameter of gcm.Sender(<server key>) object
     2. In same file (app.js) add the registrationIds generated from the devices you use to registrationIds array
     3. Now from following command you can send push request to GCM application
            node app.js
 * NodeJS app to receive requests from android client application
   --------------------------------------------------------------
     1. This is server to get messages from android clients to nodeJS server
     2. Edit app.js, now you can see this server is default working on port 3000. You can change it from edit the following line
            app.listen(<listening port>);
            Eg. app.listen(3000);
     3. Now from following command you can up the node server application to listen android clients
            node app.js
 * Android client
   --------------
     1. Edit the app/src/main/java/com/androidexample/gcm/Config.java class
           Add your php server application url to YOUR_SERVER_URL parameter
           Add GCM project number as GOOGLE_SENDER_ID
     2. Edit the app/src/main/java/com/androidexample/gcm/ToServer.class
           Add the node server url, that ur node server application is running to following line
               socket.connect(<node server url>, this);
               Eg. socket.connect("http://192.168.1.4:3000", this);
     3. Build the application and install it on android device or emulator
 * socket.io-java-client (this is a library to socket.emits from android to node app)
   ---------------------------------------------------------------------------------- 
     1. This is a client library use in android to send requests to nodeJS app
        (https://github.com/Gottox/socket.io-java-client)
     2. To build,
           ant jar
     3. Add this to your android client application
