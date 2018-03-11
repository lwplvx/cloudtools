var stompClient = null;

function setConnected(connected) {
    $("#connect").attr("disabled", connected);
    $("#disconnect").attr("disabled", !connected);

    $("#disconnect").attr("disabled", !connected);

    document.getElementById("conversationDiv").style.visibility = connected ? 'visible' : 'hidden';

    $("#response").html();

}


function connect() {
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