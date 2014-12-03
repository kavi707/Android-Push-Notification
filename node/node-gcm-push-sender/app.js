var gcm = require('node-gcm');

// create a message with default values
//var message = new gcm.Message();

// or with object values
var message = new gcm.Message({
    collapseKey: 'demo',
    delayWhileIdle: true,
    timeToLive: 3,
    data: {
        price: 'test message one'
        //key2: 'message2'
    }
});

var sender = new gcm.Sender('AIzaSyCAhLXMzr_Xzw_6unZ3zoMc-QsrKCkudas');
//var registrationIds = ['APA91bGOxxE7nHKp76MAqOjSQqwz_C-yvJtVw-_X-AbVr7DJLaCBQz0Ylps5jkow10XSrhbfD_tVtM7C_zRa-Vm_YRuaaNN1-fQGQbndaAQIZ9At6In3roSBXQwKJcV_19OANY9jGeBGTTfHN45V4zC9xXTIAb-goQ'];
var registrationIds = ['APA91bGfSNGwYvpKbikoPhvy9jC8W3tXXCF97dw15c-D1WgrrskkmwXTDKnGKFAoZP_9MVUHfWulNH1d5XK-ZxChbQCK9cuKUzDrPzgflZQXBpWmmO3MW8sovdEOxBX7b1R8bDPaiCruMixO2f1FcNn8lFoZNyHp6Hll1E_LhX6BDA_gDfkHJjc'];
var registrationIds = ['APA91bER0aPdFg5__y6YOfjrSw49tdd4UsJUQl47aX1_3hJuFmbortDSfvQbNaYaxoLfCUkRQq3-5_-_hyXadL6j3ISsBdUFsYZpiJ1R9nAt7iGlHmXMOi84NDbdz0uKfWe4Sfv_W61jm93usWWL2TbXy4WPTLESmnId-KPGIY71S9zZ35OSVqs'];

// OPTIONAL
// add new key-value in data object
/*message.addDataWithKeyValue('key1','message1');
message.addDataWithKeyValue('key2','message2');

// or add a data object
message.addDataWithObject({
    key1: 'message1',
    key2: 'message2'
});

// or with backwards compability of previous versions
message.addData('key1','message1');
message.addData('key2','message2');

message.message = 'Test message';
message.collapseKey = 'demo';
message.delayWhileIdle = true;
message.timeToLive = 3;
// END OPTIONAL

// At least one required
registrationIds.push('regId1');
registrationIds.push('regId2'); */

/**
 * Params: message-literal, registrationIds-array, No. of retries, callback-function
 **/
sender.send(message, registrationIds, 1, function (err, result) {
    console.log(result);
});
