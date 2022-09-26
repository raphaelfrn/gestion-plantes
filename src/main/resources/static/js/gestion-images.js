var empty = document.getElementById('emptyFile');
var file = document.getElementById('inputImage');

function isEmpty(){
    if(file.files.length == 0){
        empty.innerHTML = "Il n'y a aucune image sélectionnée"
    }
}