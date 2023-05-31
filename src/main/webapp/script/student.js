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

$('[data-function="cancel"]').on('click', function() {
    //Flip animation
    const target = $(this).closest('tr');
    const prev = target.prev('tr');

    target.addClass('animate__animated animate__flipOutY animate__faster');

    target.on('animationend', function() {
        target.off('animationend')
            .hide().removeClass('animate__animated animate__flipOutY animate__faster')

        prev.show().addClass('animate__animated animate__flipInY animate__faster');

        prev.on('animationend', function() {
            prev.off('animationend')
                .removeClass('animate__animated animate__flipInY animate__faster');
        });
    });

    //Reset fields
    target.find('[data-field="newFirstName"]').val(prev.find('[data-field="oldFirstName"]').data('val'));
    target.find('[data-field="newLastName"]').val(prev.find('[data-field="oldLastName"]').data('val'));
    target.find('[data-field="newGrade"]').val(prev.find('[data-field="oldGrade"]').data('val'));
    target.find('[data-field="newEmail"]').val(prev.find('[data-field="oldEmail"]').data('val'));
    target.find('[data-field="newPhone"]').val(prev.find('[data-field="oldPhone"]').data('val'));
});