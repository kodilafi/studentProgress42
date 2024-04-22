function studentModify() {
    var countChecked = 0;
    var inputElements = document.getElementsByClassName('messageCheckbox');
    for(var i=0; inputElements[i]; ++i){
        if (inputElements[i].checked){
            checkedValue = inputElements[i].value;
            countChecked++;
        }
    }

    if (countChecked == 0) {
        alert("Please, choose select anyStudent");
        return;
    }

    if (countChecked > 1) {
        alert("Please, choose one anyStudent");
        return;
    }

    var idModify;
    document.getElementById("hiddenToModify").value = idModify;
    document.getElementById("formToModify");
}

function studentDelete() {
    var countChecked = 0;
    var inputElements = document.getElementsByClassName('messageCheckbox');
    for(var i=0; inputElements[i]; ++i){
        if (inputElements[i].checked){
            checkedValue = inputElements[i].value;
            countChecked++;
        }
    }

    if (countChecked == 0) {
        alert("Please, select anyStudent");
        return;
    }
}