# GET .INI

Application Android pour copier automatiquement :

`/storage/emulated/0/.INI/METI_Mob.ini`

vers :

`/storage/emulated/0/METI_Mob.ini`

## Fonctions

- Bouton manuel `COPIER METI.INI`
- Copie automatique au démarrage du PDA
- Remplacement du fichier destination
- Vérification basique de la taille après copie
- Compatible avec Android 13 comme cible de déploiement

## Compiler gratuitement avec GitHub Actions

1. Créer un dépôt GitHub.
2. Envoyer tout le contenu de ce projet dans le dépôt.
3. Aller dans `Actions`.
4. Sélectionner `Build GET .INI APK`.
5. Cliquer sur `Run workflow`.
6. Une fois terminé, ouvrir le résultat du workflow.
7. Dans `Artifacts`, télécharger `GET-INI-debug`.
8. Extraire le ZIP et récupérer `app-debug.apk`.

## Important Android 13

Cette première version utilise directement les chemins de stockage partagé. Selon le firmware Honeywell et la configuration de sécurité du PDA, Android peut refuser l'accès direct à certains chemins.

Si le bouton affiche `Accès refusé au stockage Android`, il faudra adapter l'application avec le mécanisme de stockage autorisé par le firmware Honeywell (Storage Access Framework ou permission constructeur).

## Ouverture automatique de METI_Mob

La version actuelle gère le démarrage du PDA et le bouton manuel.

Pour lancer une copie juste avant METI_Mob, il faut connaître le package Android exact de METI_Mob. Une fois le package fourni, le launcher peut être ajouté proprement.
