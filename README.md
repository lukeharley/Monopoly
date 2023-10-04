# monopoly

Fonti 
Regolamento: 
https://www.giochi-da-tavolo.it/monpoli-istruzioni-regole/ 

Tabellone: 
https://it.wikipedia.org/wiki/Monopoly#:~:text=Giochi%20(in%20euro)-,Posteggio%20gratuito,-Via%20Marco%20Polo 

Imprevisti e Probabilità: https://answerprime.com/monopoli-elenco-imprevisti-probabilita10pt-2/ 

Contratti (Campione): https://it.scribd.com/document/327938771/Contratti-Monopoli 
https://www.giochi-da-tavolo.it/monpoli-istruzioni-regole/#:~:text=PAGARE%20RENDITE%20E%20AFFITTI
ricerca dei restanti contratti su Google Immagini e conversione dei valori da lire in euro


Sviluppo del gioco Monopoly
Scopo del gioco:
1) Diventare il giocatore più ricco dopo un certo tempo: dal momento in cui comincia la partita, cominciare a calcolare il passare del tempo. Nel momento in cui sono state raggiunte le 3 ore di gioco, il gioco si interrompe e il giocatore con più soldi VINCE.
2) Quando un giocatore deve pagare più soldi di quelli posseduti va in bancarotta ed esce dal gioco. Quando rimane un solo giocatore, prima che siano trascorse le 3 ore, il giocatore rimasto VINCE.
3) Rappresentare il contenuto della scatola del Monopoly: 1 tabellone, 8 segnalini, 28 contratti, 16 carte "Imprevisti", 16 carte "Probabilità", 32 case, 12 alberghi, 2 dadi.
   [FATTO]
4) Conto di partenza di ogni giocatore (= Patrimonio): 2 * 500€ + 4 * 100€ + 50€ + 20€ + 2 * 10€ + 5€ + 5 * 1€. Per un totale di 1500€. [FATTO]
5) Ad ogni turno il giocatore lancia i dadi e ottiene un valore che fa muovere i segnalini dei giocatori (shift = valore ottenuto come risultato del lancio dei dadi).
   Terminate/oltrepassate le 40 posizioni del tabellone, si ottengono i 200€ del Via! e il giro ricomincia da 0)
   (Se si ottengono 2 numeri uguali per le 2 facce, il giocatore ripete il turno.
   Dopo 3 volte che ciò accade, il giocatore finisce in prigione senza passare dal Via! [= senza ritirare i 200€, non vale il ricalcolo delle posizioni delle caselle].)
6) In base alla casella su cui si arriva, si potranno effettuare le seguenti azioni:
   a) Acquistare la proprietà/il terreno (se ancora disponibili) e, se si ottengono tutti i terreni di uno stesso colore, posizionare le case e quindi gli alberghi (se possibile): il costo (da saldare alla banca) è stabilito nelle carte dei Contratti.
   [Se si completa il numero di terreni dello stesso colore (= si ha un Monopolio) la rendita del solo terreno raddoppia e si sblocca la possibilità di posizionare case e poi alberghi]
   b) Pagare l'affitto/la rendita (se la proprietà è posseduta da un altro giocatore): il prezzo (da pagare alla banca) è stabilito nelle carte dei Contratti e dipende dal numero di case e alberghi
   c) Se la casella è di tipo imprevisto o probabilità (String.equals()). Pescare una carta "Imprevisti" o "Probabilità" e registrare l'effetto in base alle variabili cotenute nel testo della rispettiva carta.
   d) Se la casella è una stazione o società elettrica pagare la tassa: il costo è stabilito nelle carte dei Contratti.
   e) Andare in prigione
   f) Se la casella è Posteggio gratuito" non accade niente
   g) Se la casella è il "Via!" si ritira un premio in denaro: es. 200€
   h) Se la casella è "In prigione!" il giocatore finisce in prigione.
7) ACQUISTARE PROPRIETA’, CASE E ALBERGHI
   Se si riescono ad ottenere tutti i terreni dello stesso colore, è possibile comprare case al prezzo indicato sul Contratto. Va ricordato che si è obbligati a costruire in maniera proporzionata: non si potrà costruire una seconda casa se prima non si è costruito una casa su ognuno dei terreni di quel gruppo.
8) Potete comprare tanti edifici quanti volete nello stesso turno, a patto che siate in grado di pagarli, ma non potete costruire su un terreno se uno qualsiasi degli altri terreni dello stesso gruppo è ipotecato.
9) Terreni all'asta
   VENDITA DELLE PROPRIETA’
   È possibile vendere Servizi, Stazioni e Terreni a un qualunque altro giocatore mettendoli all’asta in qualsiasi momento. E’ importante ricordare che i terreni si possono vendere solo “nudi”, senza edifici. Se sono presenti case o alberghi andranno venduti alla metà del prezzo d’acquisto alla banca, prima di procedere con la vendita della nuda proprietà del terreno.
10) Ipoteche sulle proprietà
    È possibile ipotecare una proprietà incassando dalla banca quello che sul Contratto è definito “Valore Ipotecario”. Servizi, Stazioni e Terreni ipotecati rimangono di proprietà, e nessun altro giocatore potrà cancellare le ipoteche per impossessarsene. Le proprietà ipotecate vanno girate mostrando il retro del Contratto. Questa proprietà ipotecata non rende più nessun affitto. Tuttavia se si possiedono tutti i terreni di uno stesso colore, (Monopolio) è possibile incassare il doppio dell’affitto dovuto per la sosta su un terreno non ipotecato, anche se gli altri due terreni del medesimo colore sono ipotecati.
    Per annullare l’ipoteca è sufficiente pagare il vaore originario dell’ipoteca + il 10% di interessi alla banca. Il contratto si rigirerà a fascia in su e sarà possibile riguadagnare rendite da tale proprietà.
11) Per uscire di prigione
    Chi si trova in PRIGIONE può uscirne in uno dei seguenti modi:
1) mediante il pagamento di € 125 al suo prossimo turno, prima di lanciare i dadi
2) ottenendo un punteggio doppio con i dadi senza dover pagare nulla. In questo caso deve muovere il segnalino di un numero di caselle pari al punteggio ottenuto
3) utilizzando uno dei cartoncini sui quali è scritto USCITE GRATIS DI PRIGIONE
   Ad ogni turno trascorso in Prigione, il giocatore deve comunque lanciare i dadi. Se esce un “doppio” esce, altrimenti no. Dopo 3 turni il giocatore è costretto a pagare € 125 di multa e uscire, utilizzando per il movimento l’ultimo punteggio ottenuto.
12) (Dado Speedy)

# monopoly
