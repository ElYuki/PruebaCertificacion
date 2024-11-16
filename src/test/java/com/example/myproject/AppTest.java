package com.example.myproject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import com.ejemplo.Ahorcado;

public class AppTest {

    @Test
    void testAhorcado() throws Exception {
        // Simula las entradas necesarias para el juego
        String simulatedInput = "i\nn\nt\ne\nl\ni\ng\ne\nn\nc\ni\na\n"; // Letras correctas para adivinar "inteligencia"
        ByteArrayInputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(testInput);

        // Captura la salida del programa
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Llama al método main de Ahorcado
        Ahorcado.main(null);

        // Restaura los flujos estándar
        System.setOut(originalOut);
        System.setIn(System.in);

        // Verifica que el programa termine con un mensaje exitoso
        String output = outputStream.toString();
        assertTrue(output.contains("¡Felicidades! Has adivinado la palabra secreta: inteligencia"));
    }

    @Test
    void testJugadorGanaCon4Errores() throws Exception {
        // Entradas que permiten ganar con 4 errores
        String simulatedInput = "z\ny\nx\nq\ni\nn\nt\ne\nl\ni\ng\ne\nn\nc\ni\na\n";
        ByteArrayInputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(testInput);

        // Captura la salida del programa
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Ejecuta el método main
        Ahorcado.main(null);

        // Restaura los flujos estándar
        System.setOut(originalOut);
        System.setIn(System.in);

        // Verifica que el programa termine con un mensaje de victoria
        String output = outputStream.toString();
        assertTrue(output.contains("¡Felicidades! Has adivinado la palabra secreta: inteligencia"));
        assertTrue(output.contains("Te quedan 6 intentos"));
    }

    @Test
    void testJugadorGanaCon8Errores() throws Exception {
        // Entradas que permiten ganar con 8 errores
        String simulatedInput = "z\ny\nx\nq\nw\nr\nt\ny\nu\ni\nn\nt\ne\nl\ni\ng\ne\nn\nc\ni\na\n";
        ByteArrayInputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(testInput);

        // Captura la salida del programa
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Ejecuta el método main
        Ahorcado.main(null);

        // Restaura los flujos estándar
        System.setOut(originalOut);
        System.setIn(System.in);

        // Verifica que el programa termine con un mensaje de victoria
        String output = outputStream.toString();
        assertTrue(output.contains("¡Felicidades! Has adivinado la palabra secreta: inteligencia"));
        assertTrue(output.contains("Te quedan 2 intentos"));
    }
}
