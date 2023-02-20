function addSkillTd() {
    let myTable = document.getElementById('skillTable').getElementsByTagName('tbody')[0];

    let row = myTable.insertRow();
    let cell1 = row.insertCell(0);
    let cell2 = row.insertCell(1);
    let cell3 = row.insertCell(2);

    cell1.innerHTML = '<input type="text" class="form-control">'
    cell2.innerHTML = '<input type="range" class="form-range" min="0" max="10" id="skillRange">';
    cell3.innerHTML = '<button class="btn btn-secondary" type="button" value="update"><i class="fa-solid fa-trash-can"></i></button>';
}