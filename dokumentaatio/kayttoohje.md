# Käyttöohje

Lataa tiedosto [virtual_cat-1.1.jar](https://github.com/sumuh/ot-harjoitustyo/releases/download/viikko6/virtual_cat-1.1.jar)

## Konfigurointi

Konfiguraatiotiedoston config.properties muoto on seuraava 
```
catfile=catfile.txt
```

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla java -jar virtual_cat-1.1.jar

## Menunäkymä

Sovellus aukeaa näkymään jossa käyttäjä päättää luoko uuden kissan (Create new cat -nappi) tai jatkaako vanhaa tallennusta (Continue game -nappi).

## Uuden kissan luominen

Uusi kissa luodaan painamalla Create new cat -nappia ja kirjoittamalla tekstikenttään haluttu nimi. Sen jälkeen painetaan Select-nappia, jolloin sovellus siirtyy pelinäkymään.

## Pelinäkymä

Kissaa hoidetaan painamalla tarvittavaa nappia. Jos kissa on nälkäinen, painetaan 'Feed'-nappia, jolloin nälkä nollautuu. Statsit kasvavat ajan kuluessa.
