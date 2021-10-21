$('.demo').click(function () {
    var orderid = $(this).data('id');
    $(`#orderDetailModal${orderid}`).modal('show');
});

var orderId = $('#checkShowModal').data('id');
var message = $('#message').data('id');

if (orderId) {
    $(`#orderDetailModal${orderId}`).modal('show');
}