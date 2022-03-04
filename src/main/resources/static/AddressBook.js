$(document).ready(
    function () {
        $("#newBuddy").submit(function (event) {
            event.preventDefault();
            post();
        });

        function post() {
            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: $("#newBuddy").url,
                data: JSON.stringify({
                    name: $("#name").val(),
                    address: $("#address").val()
                }),
                dataType: 'json'
            }).then(function (data) {
                console.log(data);
            })
        }
    });
