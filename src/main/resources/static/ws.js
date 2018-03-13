var stompClient = null;

function setConnected(connected) {
    $("#connect").attr("disabled", connected);
    $("#disconnect").attr("disabled", !connected);

    $("#disconnect").attr("disabled", !connected);

    document.getElementById("conversationDiv").style.visibility = connected ? 'visible' : 'hidden';

    $("#response").html();

}


function connect() {
    p2p();

    var socket = new SockJS('/endpointLwp');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('connect: ' + frame)
        stompClient.subscribe('/topic/getResponse', function (response) {

            showResponse(JSON.parse(response.body).responseMessage);

        })
    });

}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }

    setConnected(false);

    console.log("disconnected");

}

function sendName() {
    var name = $("#name").val();
    stompClient.send("/welcome", {}, JSON.stringify({'name': name}));

}

function showResponse(message) {
    var response = $("#response");
    response.html(message);

}


function p2p() {
    var sock = new SockJS("/endpointChat");
    var stomp = Stomp.over(sock);
    stomp.connect("guest", "guest", function (frame) {
        stomp.subscribe("/user/queue/notifications", handleNotification)
    })
    var interval = setInterval(function () {
        if (sock.closed) {

        }
        stomp.send("/chat", "hello " + (new Date().getTime()));
    }, 5000);

    sock.onopen = function () {
        console.log('open');
        sock.send('test');
    };

    sock.onmessage = function (e) {
        console.log('message', e.data);
        //  sock.close();
    };

    sock.onclose = function () {
        console.log('close');
        clearInterval(interval);
    };

    setTimeout(function () {
        sock.close();
    }, 30000)
}

function handleNotification(message) {
    console.log(message, " handleNotification")
}