/**
 * Created by RENT on 2016-12-17.
 */

$.ajaxSetup({contentType: 'application/json'});


$.get('/user', function (helloMessage) {
    $('h1').append(helloMessage);
});

$.get('user/all', function (users) {
    for(var i = 0; i < users.length; i++) {
        $('#user').append('<li class="list-group-item">' + users[i] + '</li>');
    }
});

$.get('/api/message', function (messages) {
    for(var i = 0; i < messages.length; i++){
        appendMessage(messages[i]);
    }
});

function appendMessage(mes) {
    $('#messages').append('<li class="list-group-item">'+mes.senderId+'>'+ mes.receiverId+ '      '+mes.body+'</li>');
};

$(function () {
    $('#sendBtn').click(function () {
        createMessage();
    });
});


function createMessage() {
    var message = {
        senderId: $('#senderId').val(),
        receiverId: $('#receiver').val(),
        body: $('#body').val()
    };
    $.post('/api/message', JSON.stringify(message), function (data) {
        appendMessage(data);
    }, 'json');
};


