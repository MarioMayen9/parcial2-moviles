package com.mayencastro.parcial2moviles.data

import com.mayencastro.parcial2moviles.data.model.Sport

val name = "Basketball"
val rules = "Dos equipos de 5 jugadores cada uno compiten en un campo rectangular.\n" +
        "El objetivo es anotar puntos lanzando la pelota en la canasta del equipo contrario.\n" +
        "Se permite driblar la pelota mientras se camina o corre.\n" +
        "Se considera falta si un jugador empuja, obstruye o comete una falta técnica."


val name2 = "Football"
val rules2 = "El juego se disputa entre dos equipos de 11 jugadores cada uno.\n" +
        "El objetivo es marcar más goles que el equipo contrario.\n" +
        "No se permite el uso de las manos, excepto por el arquero dentro de su área.\n" +
        "Se considera falta si un jugador comete una infracción contra otro jugador, como un tackle por detrás."


val name3="Tenis"
val rules3="El juego se disputa entre dos jugadores o parejas de jugadores.\n" +
        "El objetivo es golpear la pelota sobre la red y que esta caiga dentro del campo contrario.\n" +
        "Se juega en una cancha dividida en mitades por una red.\n" +
        "Se considera punto si el jugador contrario no logra devolver la pelota dentro de las líneas del campo."

val name4="Atletismo"
val rules4="Incluye diversas disciplinas como carreras de velocidad, saltos y lanzamientos.\n" +
        "El objetivo es alcanzar la mayor velocidad, distancia o altura en cada disciplina.\n" +
        "Se compite en una pista o área específica para cada disciplina.\n" +
        "Se considera falta si un atleta comienza antes del disparo de salida en carreras o pisa fuera de la zona de salto."
var model = mutableListOf(
    Sport(name, rules),//, category, description, qualification),
    Sport(name2, rules2), //, category2, description2, qualification2),
    Sport(name4, rules4),
    Sport(name3, rules3)
)