$('.delete').on('click', function() {
    let index = $(this).data('index');

    $.ajax({
        type: "DELETE",
        url: "./teacher?delete=" + index,
        success: function() {
            location.reload();
        }
    });
});

$('.edit').on('click', function() {
    const target = $(this).closest('tr');
    target.addClass('animate__animated animate__flipOutY animate__faster');

    target.on('animationend', function() {
        target.css('display', 'none');
        target.removeClass('animate__animated animate__flipOutY animate__faster')

        const next = target.next('tr');
        next.css('display', 'table-row');
        next.addClass('animate__animated animate__flipInY animate__faster');

        next.on('animationend', function() {
           next.removeClass('animate__animated animate__flipInY animate__faster');
           next.off('animationend');
        });

        target.off('animationend');
    });
});

$('.cancel').on('click', function() {
   const target = $(this).closest('tr');
   const prev = target.prev('tr');

   target.addClass('animate__animated animate__flipOutY animate__faster');

   target.on('animationend', function() {
      target.css('display', 'none');
      target.removeClass('animate__animated animate__flipOutY animate__faster')

      prev.css('display', 'table-row');
      prev.addClass('animate__animated animate_flipInY animate__faster');

       prev.on('animationend', function() {
           prev.removeClass('animate__animated animate__flipInY animate__faster');
           prev.off('animationend');
       });

       target.off('animationend');
   });

   target.find('[data-field="newFirstName"]').val(prev.find('[data-field="oldFirstName"]').data('val'));
   target.find('[data-field="newLastName"]').val(prev.find('[data-field="oldLastName"]').data('val'));
   target.find('[data-field="newDepartment"]').val(prev.find('[data-field="oldDepartment"]').data('val'));
   target.find('[data-field="newEmail"]').val(prev.find('[data-field="oldEmail"]').data('val'));
   target.find('[data-field="newPhone"]').val(prev.find('[data-field="oldPhone"]').data('val'));
});