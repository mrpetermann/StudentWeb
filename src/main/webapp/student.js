$(".delete").on('click', function() {
    let index = $(this).data("index");

    $.ajax({
        type: "DELETE",
        url: "./student?delete=" + index,
        success: function() {
            location.reload();
        }
    });
});