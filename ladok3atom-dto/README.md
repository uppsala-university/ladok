# Informationsobjekt ATOM
Ladok's ATOM-gränssnitt publicerar händelser från studieprocessen och som utgår från dess huvudsakliga IT-stöd. 

Händelserna publiceras i ett flöde baseras på standarden ATOM. Varje händelse beskrivs i XML enligt ett fastslaget XML-schema. 

För att hantera händelserna i java-kod på ett objektorienterat sätt behövs en översättning mellan XML-representationen. Det som inom datavetenskap kallas deserialisering eller marchalling. Den omvända vägen, att ta objektrepresentation ur minnet till disk eller överföring kallas serialisering eller unmarchalling. 

Projektet innehåller värdeobjekt för alla händelser som publiceras i ladoks ATOM-flöde.

Använd `ladok3-dto-common` för att på ett enkelt sätt hantera översättningsrutiner.