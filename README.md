# Ladok integrationskod
Projektet innehåller generell java-kod för att integrera mot nya Ladok's tekniska gränssnitt. 

Eftersom att nya Ladok i huvudsak tillhandahåller två typer av tekniska gränssnitt - REST och ATOM - är projektet i huvudsak uppdelat i två delar:

* ladok3atom-client
* ladok3rest-client

För att hantera de informationsobjekt som respektive tekniskt gränssnitt använder sig av finns ytterligare två stödbibliotek i:

* ladok3atom-dto
* ladok3rest-dto

där informationsobjekten är helt fristående och där respektive klient har ett bereoende till det bibliotek som innehåller de informationsobjekt som är kopplade till aktuellt tekniskt gränssnitt. 

För att hantera händelserna i java-kod på ett objektorienterat sätt behövs en översättning mellan XML-representationen och java-koden. Det som inom datavetenskap kallas deserialisering eller marchalling. Den omvända vägen, att ta objektrepresentation ur minnet för att skriva till disk eller transportera kallas serialisering eller unmarchalling. Översättningsrutinerna behövs både för REST och ATOM och gemensamma rutiner finns samplade i projektet

* ladok3-dto-common