function logout(){
    Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Desconectado exitosamente',
        showConfirmButton: false,
        timer: 1500
    });
    window.setTimeout(function() {
        window.location.href = '/logout';
    }, 1500);

}