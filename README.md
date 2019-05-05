# Virtual cat

Sovellus on klassikoksi muodostuneesta virtuaalisesta lemmikistä Tamagotchista inspiraationsa saanut peli, jossa käyttäjä pitää huolta virtuaalisesta kissasta.

## Dokumentaatio

[Käyttöohje](https://github.com/sumuh/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/sumuh/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/sumuh/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

[Arkkitehtuuri](https://github.com/sumuh/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/sumuh/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)

## Releaset

[Viikko 5 release](https://github.com/sumuh/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6 release](https://github.com/sumuh/ot-harjoitustyo/releases/tag/viikko6)

## Komentorivitoiminnot

Ohjelman suoritus komentoriviltä komennolla

<pre>
mvn compile exec:java -Dexec.mainClass=ui.Main
</pre>

Testit suoritetaan komennolla

<pre>
mvn test
</pre>

Testikattavuusraportti luodaan komennolla

<pre>
mvn test jacoco:report
</pre>

Checkstylen suoritus komennolla

<pre>
mvn jxr:jxr checkstyle:checkstyle
</pre>

Jar-tiedoston luonti komennolla mvn package ja suoritus komennolla

<pre>
java -jar virtual_cat-1.0-SNAPSHOT.jar
</pre>

Javadocin generointi komennolla

<pre>
mvn javadoc:javadoc
</pre>


