$('[data-function="delete"]').on('click', function() {
    let index = $(this).data('index');

    $.ajax({
        type: "DELETE",
        url: "./student?delete=" + index,
        success: function() {
            location.reload();
        }
    });
});

$('[data-function="edit"]').on('click', function() {
    const target = $(this).closest('tr');
    const next = target.next('tr');

    target.addClass('animate__animated animate__flipOutY animate__faster');

    target.on('animationend', function() {
        target.off('animationend')
            .hide().removeClass('animate__animated animate__flipOutY animate__faster')

        next.show().addClass('animate__animated animate__flipInY animate__faster');

        next.on('animationend', function() {
            next.off('animationend')
                .removeClass('animate__animated animate__flipInY animate__faster');
        });
    });
});