var voitures = document.getElementById("voiture");
var liste = document.getElementById("liste");


fetch('http://localhost:8080/voitures')
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    for (var i = 0; i < data.length; i++) {
               texteVoiture(data[i])
    }
    console.log(data);
  });


function texteVoiture(item) {
    
    var id = item.id;

    var modele = item.modele;

    var prix = item.prix;

    var nbPlaces = item.nbPlaces;

    var reserve = item.reserve;

    var text = "<td>"+id+"</td>"
                + "<td>"+modele+"</td>"
                + "<td>"+prix+"</td>"
                + "<td>"+nbPlaces+"</td>"
                + "<td>"+reserve+"</td>";

    voitures += "<tr>"+text+"</tr>";

    liste.innerHTML = voitures;

}

