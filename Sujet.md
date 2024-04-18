### Objectif
Création d'un système de gestion de temps pour une entreprise, permettant aux employés de pointer à l'arrivée et au départ, et aux administrateurs de suivre les heures travaillées, les heures supplémentaires, et d'effectuer des rapports.



### Fonctionnalités



#### Application Mobile (pour les salariés)
- **Authentification sécurisée** : Connexion via un système d'identification personnel.
- **Interface de pointage** : Permettre aux salariés de "pointer" à leur arrivée et départ via l'application.
- **Visualisation des heures** : Les salariés peuvent consulter leurs heures travaillées hebdomadaires et leurs heures supplémentaires.



#### Application Web ou Lourde (pour les administrateurs)
- **Tableau de bord** : Vue d'ensemble des pointages de tous les employés.
- **Gestion des employés** : Ajout, modification, et suppression des informations des employés.
- **Rapports** : Génération de rapports sur les heures travaillées, les heures supplémentaires, etc.



#### API REST
- **Centralisation des données** : L'API servira de pont entre les applications mobiles et l'application d'administration.
- **Endpoints sécurisés** : Fournir des endpoints pour les opérations CRUD sur les employés, les pointages, etc.
- **Authentification et autorisation** : Gestion des accès selon les rôles des utilisateurs.



### Sécurité
- **Authentification forte** : Implémentation de JWT  pour sécuriser les sessions.
- **Sécurisation de l'API** : Restrictions d'accès basées sur les rôles, validation des entrées pour se prémunir contre les injections SQL, etc.



### Déploiement
- **Utilisation de Docker** : Conteneurisation de l'application pour faciliter le déploiement et l'isolation des services.
- **Documentation de déploiement** : Instructions claires pour déployer l'application en utilisant Docker.



### Livrables
- **Maquettes** : Designs des interfaces utilisateur pour les applications mobiles et web.
- **Conception** : Diagrammes UML (Use Case, Sequence, Class Diagrams).
- **Code source** : Avec des commentaires appropriés et une structure organisée.
- **Tests** : Tests unitaires et d'intégration pour chaque composant.
- **Documentation** : Guide utilisateur et technique, documentation de l'API..