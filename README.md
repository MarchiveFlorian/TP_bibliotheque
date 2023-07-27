# TP_bibliotheque

Exemple POST Auteurs: 

{
  "id": 4,
  "nom": "Tolkien",
  "prenom": "JRR",
  "nationalité": "Américain"
}

Exemple POST Categories:

{
  "genre": "Fantastique"
}

Exemple POST Livres:

{
  "title": "Le seigneur des anneaux",
  "auteur" : {"id" : 4},
  "collections" : [
    {"id" : 1},
    {"id" : 2}
    ]
}
