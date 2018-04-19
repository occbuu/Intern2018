function validate() {
    var m = document.getElementById("m").value;
    var n = document.getElementById("n").value;
    var path = document.getElementById("path").value;
    var path_2 = document.getElementById("path_2").value;
    if (!typeof m === 'number' || !typeof n === 'number' || m > 100 || n > 100 || m < -100 || n < -100) {
        alert('Invalid input.');
        return false;
    } else {
        return true;
    }
}