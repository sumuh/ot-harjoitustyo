# Virtual cat

Sovellus on klassikoksi muodostuneesta virtuaalisesta lemmikistä Tamagotchista inspiraationsa saanut peli, jossa käyttäjä pitää huolta virtuaalisesta kissasta.

## Dokumentaatio

[dokumentointi.md](https://github.com/sumuh/ot-harjoitustyo/blob/master/dokumentaatio/dokumentointi.md)

[tyoaikakirjanpito.md](https://github.com/sumuh/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

[arkkitehtuuri.md](https://github.com/sumuh/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[viikko 5 release](https://github.com/sumuh/ot-harjoitustyo/releases/tag/viikko5)

[viikko 6 release](https://github.com/sumuh/ot-harjoitustyo/releases/tag/viikko6)

## Komentorivitoiminnot

Ohjelman suoritus komentoriviltä komennolla mvn compile exec:java -Dexec.mainClass=ui.Main

Testit suoritetaan komennolla mvn test

Testikattavuusraportti luodaan komennolla mvn test jacoco:report

Checkstylen suoritus komennolla mvn jxr:jxr checkstyle:checkstyle

Jar-tiedoston luonti komennolla mvn package ja suoritus komennolla java -jar virtual_cat-1.0-SNAPSHOT.jar

Javadocin generointi komennolla mvn javadoc:javadoc


