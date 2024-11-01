package com.cunoc.CaptchaForge.Model.Utility.FileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drymnz
 */
public class FileInput {

    public String cargarArchivoTexto(File carchivo) {
        if (!carchivo.exists() || !carchivo.canRead()) {
            System.out.println("El archivo no existe o no se puede leer.");
            return "";
        }
        StringBuilder extraje = new StringBuilder();
        try (FileInputStream entrada = new FileInputStream(carchivo);
                InputStreamReader lector = new InputStreamReader(entrada, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(lector)) {

            String linea;
            // Leer el archivo línea por línea
            while ((linea = bufferedReader.readLine()) != null) {
                extraje.append(linea).append(System.lineSeparator());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error en la lectura: Archivo no encontrado");
            Logger.getLogger(FileInput.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error en la lectura del archivo");
            Logger.getLogger(FileInput.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Retornar el texto extraído
        String readString = extraje.toString();
        readString = readString.replace("\\u0027", "'");
        readString = readString.replace("\\u003d", "=");
        return readString;
    }

    public File exiteDireccion(File verificar) {
        if (verificar.exists()) {
            return verificar;
        } else {
            try {
                if (verificar.createNewFile()) {
                    System.out.println("FUE CREADO " + verificar.getName());
                    return verificar;
                } else {
                    System.out.println("NO SE PUDO CREAR " + verificar.getName());
                }
            } catch (IOException ex) {
                Logger.getLogger(FileInput.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}