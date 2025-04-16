API de Gestion des Notes Étudiantes.
L'objectif de cette API est de permettre aux enseignants de gérer les notes des étudiants pour
différents cours. L'API doit fournir des fonctionnalités pour enregistrer, mettre à jour, supprimer et
consulter les notes des étudiants. Elle doit également permettre de générer des rapports de notes
par cours ou par étudiant.

Endpoints
• Étudiants :
POST /students : Ajouter un nouvel étudiant
PUT /students/{id} : Mettre à jour un étudiant
DELETE /students/{id} : Supprimer un étudiant
GET /students : récupération de tt les étudiants
GET /students/{id} : Récupérer un étudiant par ID
• Cours :
POST /courses : Ajouter un nouveau cours
PUT /courses/{id} : Mettre à jour un cours

DELETE /courses/{id} : Supprimer un cours
GET /courses : Récupérer tous les cours
GET /courses/{id} : Récupérer un cours par ID.

• Notes :
• POST /grades : Enregistrer une nouvelle note
• PUT /grades/{id} : Mettre à jour une note
• DELETE /grades/{id} : Supprimer une note
• GET /grades/student/{studentId} : Récupérer les notes d'un étudiant
• GET /grades/course/{courseId} : Récupérer les notes pour un cours
• Rapports :
GET /reports/course/{courseId} : Générer un rapport des notes moyennes pour un cours
GET /reports/student/{studentId} : Générer un rapport des notes moyennes pour un
étudiant
