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

$('[data-function="save"]').on('click', function() {
    let index = $(this).data('index');

    //Updated values
    const target = $(this).closest('tr');
    let newFirstName = target.find('[data-field="newFirstName"]').val();
    let newLastName = target.find('[data-field="newLastName"]').val();
    let newGrade = target.find('[data-field="newGrade"]').val();
    let newEmail = target.find('[data-field="newEmail"]').val();
    let newPhone = target.find('[data-field="newPhone"]').val();

    //Send update request to server
    $.ajax({
        type: "PUT",
        url: './student?index=' + index + '&newFirstName=' + newFirstName +
            '&newLastName=' + newLastName + '&newGrade=' + newGrade +
            '&newEmail=' + newEmail + '&newPhone=' + newPhone,
        success: function() {
            location.reload();
        }
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