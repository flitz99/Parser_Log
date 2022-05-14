# 2022T4
Heimdall: Analizzatore via web-app di log Apache web-server, con funzionalità di analisi statistiche a fini di sicurezza e/o commerciali, rilevamento e risoluzione minacce, notificazione eventi malevoli, geolocalizzazione ip.
## membri del Team
Progetto anno 2021/2022 del team n°4, composto da: 
Massimiliano Villa matr 136435, ruolo: full-stack developer
Japoco Vecchi matr 119362, scrum master developer backend
Lorenzo Lucchina matr 135609, project owner, sysadmin
Simone Baroni matr 122586, developer tester
Filippo Reggiani matr 148084, developer database architect
Janath Uthayakumar matr 145610, developer frontend

### Strumenti utilizzati:
Gitlab: dw.gnet.it/2022T4 per CI/CD
Mattermost: per comunicazione interna
Taiga: per pianificazione user stories

### Heimdal: un software per analizzare i file di log di un webserver 

Il nostro software si basa sull’analisi dei file di log, essi verranno analizzati da un'appplicazione backend, con il compito di creare una distinzione tra 2 tipi di connessioni: Malevole, benevole.
Il nostro frontend presenta all'utilizzatore la possibilità di rivedere i file di log riformattati per una migliore fruibilità e darà statistiche riguardanti le connessioni. 


### Installazione
Installazione su una macchina locale (testata su Debian 11 stable):
Prerequisiti: una versione aggiornata di docker e docker-container (guida download: https://docs.docker.com/engine/install/debian/)
Step 1: dirigersi nella cartella 2022t4/code/Heimdall
Step 2: sudo docker build --file=backend.dockerfile -t playground-web-backend .
Step 3: dirigersi nell cartella 2022t4/Frontend
Step 4: sudo docker build --file=frontend/frontend.dockerfile -t playground-web-frontend .
step 5: dirigersi nella cartella 2022t4/code
step 6: sudo docker-compose -f docker-compose.yml up (digitare y <INVIO> quando viene richiesto)
step 7: aprire un browser e collegarsi all'indirizzo 0.0.0.0:3000
Aggiornamenti Sprint 1:
Lo sviluppo dell'applicativo si è spostato sul branch development
