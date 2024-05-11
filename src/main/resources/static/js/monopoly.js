function lanciaDadi() {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/lanciaDadi", true);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var response = JSON.parse(xhr.responseText);
                aggiornaInterfaccia(response);
            } else {
            console.error("Richiesta non riuscita. Errore " + xhr.status);
            } 
        }
    };

    xhr.send();
}

function aggiornaInterfaccia(data) {
    console.log("Il risultato del dado è " + data.risultatoDado); 
    console.log("La nuova posizione è " + data.posizione); 
    console.log("Il nuovo portafoglio è " + data.portafoglio); 

    var caselleTabellone = document.querySelectorAll(".casella > div");
    caselleTabellone.forEach(function(casella) {
        casella.classList.remove("posizioneSegnalino");
    });
    
    var posizione = data.posizione; 
    var casellaOccupata = document.getElementById("casella_" + posizione).children[1];
    casellaOccupata.classList.add("posizioneSegnalino");

    var portafoglio = document.querySelector(".portafoglio > b");
    portafoglio.textContent = data.portafoglio + "€";
   
    
}

function resettaPartita() {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/resettaPartita", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
}