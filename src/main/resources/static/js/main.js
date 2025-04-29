function deleteWine(id) {
    if (confirm("Sind Sie sicher?")) {
        location.href = "/delete?id=" + id;
    }
}

function showDetails(id){
    location.href = "details?id=" + id;
}
