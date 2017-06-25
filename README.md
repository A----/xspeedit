Robby met les petites boîtes dans les grandes pour XspeedIt !

## Installation

Robby requiert un JRE 1.7 ou supérieur.

Les JAR peuvent être trouvés dans la section [Releases](https://github.com/A----/xspeedit/releases).

## Utilisation

Pour exécuter Robby :

```
java -jar xspeedit-robby-1.1.0.jar "12456789"
```

Exemples de retours :

```
> java -jar target/xspeedit-robby-1.1.0.jar 163841689525773
91/82/81/73/73/64/6/55

> java -jar target/xspeedit-robby-1.1.0.jar


> java -jar target/xspeedit-robby-1.1.0.jar 12345AAD
Invalid input: 12345AAD
```

## Génération du rapport d'optimisation

Pour activer les tests d'optimisation, ajouter le profil `optimisation` à l'exécution de Maven :

```shell
> mvn test -Poptimisation
[…]
com.xspeedit.robby.packagingstrategies.BasicPackagingStrategy (Test set of 10 elements)
        100 runs for a total of 823.128ms (8.23128ms per run avg)
        68 runs were suboptimized (68.0%)
        658 boxes shipped, minimum was 577 (114.03812824956673%)

com.xspeedit.robby.packagingstrategies.AdvancedPackagingStrategy (Test set of 10 elements)
        100 runs for a total of 1569.078ms (15.69078ms per run avg)
        0 runs were suboptimized (0.0%)
        577 boxes shipped, minimum was 577 (100.0%)
```