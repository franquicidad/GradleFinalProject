package com.example.jokesjavalibrary;

import java.util.Random;

public class JokeJavaLibrary {

    private static final String [] jokes ={
       "¿Por qué un tomate no toma cafe? porque toma te",
       "¡Soldado Miralles!¡¿Si, mi capitán?¡No lo vi ayer en la prueba de camuflaje.¡Gracias mi capitán!",
       "¿Alcohol? No, yo no tomo, esa palabra no está en mi vodkabulario, espera que la busco en la whiskypedia",
       "¿Sabías que Beethoven dedicó su quinta sinfonía a su padre?¿Cómo lo sabes?Fíjate en el comienzo: Para papá…",
       "Que guarda Darth Vader en su nevera??: Helado OSCURO"

    } ;

    public static String tellRandomJoke(){
        return jokes[new Random().nextInt(4)];
    }
}
