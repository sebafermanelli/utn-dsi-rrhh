$(function () {
    $("#fecha").datepicker({
        dateFormat: "dd-mm-yy",
        minDate: new Date()
    });
    $("#form").validate({
        rules: {
            fecha: {
                required: true,
                dpDate: true
            }
        }
    });
});