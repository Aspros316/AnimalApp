package com.example.animalapp.data.remote

import androidx.annotation.DrawableRes
import com.example.animalapp.R

data class Animal(
    val id: Int,
    @DrawableRes val imageResource: Int,
    val name: String,
    val abilities: List<String>
)

val animalList = listOf(
    Animal(
        id = 1,
        imageResource = R.drawable.tigre,
        name = "Tigre",
        abilities = listOf(
            "Pueden correr a 72 kilómetros por hora",
            "tienen mandíbulas poderosas que ejercen casi 500 kilogramos de fuerza para atrapar a sus presas",
            "Suelen cazar animales grandes"
        ),
    ),
    Animal(
        id = 2,
        imageResource = R.drawable.oso,
        name = "Oso",
        abilities = listOf(
            "son corredores, escaladores y nadadores expertos",
            "Los osos utilizan refugios, como cuevas y troncos, como guaridas",
            "la mayoría de las especies ocupan sus guaridas en invierno durante un largo período de hibernación, de hasta cien días.",
        )
    ),
    Animal(
        id = 3,
        imageResource = R.drawable.camello,
        name = "Camello",
        abilities = listOf(
            "Es muy largo y flexible para poder comer de las plantas altas y del suelo Además lo utilizan para equilibrarse., Dulce de leche, agua También se llama corcova, les ayuda a bajar temperatura de su cuerpo cuando hace mucho calor.",
            "También se llama corcova, les ayuda a bajar la temperatura de su cuerpo cuando hace mucho calor.",
            "Las patas Son muy largas, para mantener el cuerpo lejos del suelo que se calienta cuando hace mucho calor.",
            "Tienen callos En las patas, los pies y en el pecho. Son zonas sin pelo con la piel muy dura."
        )
    ),
    Animal(
        id = 4,
        imageResource = R.drawable.tortuga,
        name = "Tortuga ",
        abilities = listOf(
            "Las tortugas carecen de dientes en las mandíbulas. Tienen oídos primitivos, un excelente sentido del olfato y una buena visión bajo el agua.",
            "Sus aletas son largas y presentan una o dos uñas reducidas en las delanteras, con la excepción de la tortuga laúd, la cual carece de uñas.",
        )
    ),
    Animal(
        id = 5,
        imageResource = R.drawable.perezoso,
        name = "Perezoso",
        abilities = listOf(
            "El perezoso de dos dedos pasa la mayor parte del tiempo en árboles, aunque pueden viajar por el suelo para llegar a otro árbol y son capaces de nadar.",
            "Poder nadar otorga a los perezosos la libertad de cruzar ríos y moverse entre árboles cuando el bosque se inunda.",
            "suelen dormir unas 15 horas al día. Este comportamiento puede parecer arriesgado en una selva tropical llena de depredadores."
        )
    )
)
