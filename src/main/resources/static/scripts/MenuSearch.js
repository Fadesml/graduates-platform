function search() {
    let preGraduateName = document.getElementById("preGraduateName").value;
    window.location = 'http://localhost:8080?preGraduateName='+preGraduateName;
}