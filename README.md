Robby met les petites boîtes dans les grandes pour XspeedIt !

## Installation

Robby requiert un JRE 1.7 ou supérieur.

Les JAR peuvent être trouvés dans la section [Releases](https://github.com/A----/xspeedit/releases).

## Utilisation

Pour exécuter Robby :

```
java -jar xspeedit-robby-1.2.0.jar 123456789
```

Exemples de retours :

```
> java -jar target/xspeedit-robby-1.2.0.jar 163841689525773
19/28/37/37/46/55/18/6

> java -jar target/xspeedit-robby-1.2.0.jar


> java -jar target/xspeedit-robby-1.2.0.jar 12345AAD
Invalid input: 12345AAD
```

## Génération du rapport d'optimisation

Pour activer les tests d'optimisation, ajouter le profil `optimisation` à l'exécution de Maven :

```shell
> mvn test -Poptimisation
[…]
com.xspeedit.robby.packagingstrategies.BasicPackagingStrategy (Test set of 10 elements)
        1000 runs for a total of 2761.357ms (2.761357ms per run avg)
        704 runs were suboptimized (70.4%)
        6617 boxes shipped, minimum was 5792 (114.24378453038673%)

com.xspeedit.robby.packagingstrategies.AdvancedPackagingStrategy (Test set of 10 elements)
        1000 runs for a total of 4461.519ms (4.461519ms per run avg)
        1 runs were suboptimized (0.1%)
        5793 boxes shipped, minimum was 5792 (100.01726519337016%)

com.xspeedit.robby.packagingstrategies.RecursivePackagingStrategy (Test set of 10 elements)
        1000 runs for a total of 11041.795ms (11.041795ms per run avg)
        0 runs were suboptimized (0.0%)
        5792 boxes shipped, minimum was 5792 (100.0%)
```