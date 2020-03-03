/*!
    * Start Bootstrap - SB Admin v6.0.0 (https://startbootstrap.com/templates/sb-admin)
    * Copyright 2013-2020 Start Bootstrap
    * Licensed under MIT (https://github.com/BlackrockDigital/startbootstrap-sb-admin/blob/master/LICENSE)
    */
    (function($) {
    "use strict";

    // Add active state to sidbar nav links
    var path = window.location.href; // because the 'href' property of the DOM element is the absolute path
        $("#layoutSidenav_nav .sb-sidenav a.nav-link").each(function() {
            if (this.href === path) {
                $(this).addClass("active");
            }
        });

    // Toggle the side navigation
    $("#sidebarToggle").on("click", function(e) {
        e.preventDefault();
        $("body").toggleClass("sb-sidenav-toggled");
    });

    
    
})(jQuery);

//déclaration de constante
const liste = document.getElementById("liste");
let voitures = "";

// fetch / Récupération des données depuis l'API
fetch('http://localhost:8080/voitures')
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    for (var i = 0; i < data.length; i++) {
               texteVoiture(data[i])
    }
  });


//fonction qui affiche
function texteVoiture(item) {
    
    //Remplacement de l'underscore par un espace
    let modele = item.modele;
    let model = modele[0].toUpperCase() + modele.slice(1); 
   
    let text = `<td>${item.id}</td>
                <td>${model.replace("_", " ")}</td>
                <td>${item.prix}</td>
                <td>${item.nbPlaces}</td>
                <td>${item.reserve  == true ? "réservé" : "disponible"}</td>`;

    voitures += `<tr>${text}</tr>`;

    liste.innerHTML = voitures;
}
