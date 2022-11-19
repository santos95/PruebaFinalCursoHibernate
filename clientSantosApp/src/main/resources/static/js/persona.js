// Call the dataTables jQuery plugin
$(document).ready(function() {
    //alert(1234);
    cargarPersonaSantos();
    $('#persona_santos').DataTable();
});

async function cargarPersonaSantos() {
    const request = await fetch('http://localhost:8090/santos/persona/todo', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-type': 'application/json',
            'Authorization': 'Basic test:test'
        },
    });
    const persona_santos = await request.json();

    console.log(persona_santos);
}
