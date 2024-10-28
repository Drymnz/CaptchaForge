# CaptchaForge

Un proyecto web para generar diferentes tipos de captchas utilizando un lenguaje de etiquetado personalizado. El sistema traduce estos captchas a páginas web independientes que son desplegadas por un servidor web.

## 🌟 Características

### Arquitectura General
- Sistema cliente-servidor
- Aplicación web en Angular para creación y gestión de captchas
- API en Spring Boot
- Servidor para gestionar comunicación y almacenamiento

### Comunicación y Protocolos
- Sockets para comunicación servidor-aplicaciones
- Protocolo HTTP para la aplicación web
- Lenguaje CC (híbrido entre CC y SCRIPTING)

### Principales Funcionalidades

#### 📝 Editor de Captchas
- Crear nuevos archivos .cc
- Abrir archivos existentes
- Guardar cambios
- Guardar como nuevo archivo
- Indicador de línea y columna actual

#### 📊 Reportes
- **Utilización de Captchas:**
  - Nombre del captcha
  - Cantidad de usos
  - Aciertos y fallos
  - Última fecha de uso

- **Errores de Compilación:**
  - Tipo de error
  - Línea y columna
  - Descripción
  - Solución sugerida

#### 🔍 Tabla de Símbolos en Tiempo Real
- Posición
- Identificador
- Tipo
- Modo
- Procedimiento
- Número de ejecución

### 💾 Almacenamiento
- Estructura JSON para reportes
- Base de datos para captchas
- Persistencia de datos entre reinicios

### 🛠️ Tecnologías
- Angular, HTML, CSS, TypeScript
- Spring Boot
- JFlex y Cup (análisis léxico y sintáctico)
- Jison (componente Angular)

## 🚀 Instalación

### Requisitos del Sistema

#### Linux
- Distribuciones: Ubuntu, Fedora, Debian
- RAM: 4 GB mínimo (8 GB recomendado)
- Espacio en disco: 6 GB total
  - 2 GB para Android Studio
  - 4 GB para Android SDK y emulador

#### Windows
- Windows 10 (64-bit recomendado)
- RAM: 4 GB mínimo (8 GB recomendado)
- Espacio en disco: 6 GB total

### Pasos de Instalación

#### Java
Para Arch Linux y derivadas:
```bash
sudo pacman -Syu jdk23-openjdk
```

#### Git
Para Arch Linux y derivadas:
```bash
sudo pacman -Syu git
```

## 🎯 Sintaxis CC

### Etiquetas Básicas

| Etiqueta CC | Descripción | Análogo HTML |
|-------------|-------------|--------------|
| `<C_CC>` | Etiqueta raíz (parámetros: id, name) | `<HTML>` |
| `<C_HEAD>` | Encabezado del documento | `<HEAD>` |
| `<C_TITLE>` | Título del documento | `<TITLE>` |
| `<C_LINK>` | Enlaces externos (parámetro: href) | `<LINK>` |
| `<C_BODY>` | Cuerpo del documento (parámetro: background) | `<BODY>` |
| `<C_SPAM>` | Contenedor de texto | `<SPAM>` |
| `<C_DIV>` | Contenedor genérico | `<DIV>` |
| `<C_IMG>` | Imágenes | `<IMG>` |
| `<C_BR>` | Salto de línea | `<BR>` |
| `<C_BUTTON>` | Botón | `<BUTTON>` |
| `<C_H1>` | Título | `<H1>` |
| `<C_P>` | Párrafo | `<P>` |

### Parámetros Comunes

- `href`: URL destino
- `background`: Color de fondo
- `color`: Color del texto
- `font-size`: Tamaño de fuente en pixeles
- `font-family`: Tipo de letra (Courier, Verdana, Arial, Geneva, sans-serif)
- `text-align`: Alineación (left, right, center, justify)
- `id`: Identificador único
- `class`: Clase CSS

## 🔧 Sintaxis de Scripting

### Estructura Básica
```javascript
<C_SCRIPTING>
    ON_LOAD () [
        // Instrucciones al cargar
    ]
    
    FUNCTION_NOMBRE () [
        // Instrucciones de la función
    ]
</C_SCRIPTING>
```

### Tipos de Datos

| Tipo | Descripción | Ejemplo |
|------|-------------|---------|
| `integer` | Números enteros | `1, -40, 200` |
| `decimal` | Números decimales | `1.2, -0.34` |
| `boolean` | Valores booleanos | `true, false` |
| `char` | Caracteres individuales | `'a', 'B', '#'` |
| `string` | Cadenas de texto | `"Hola mundo"` |

### Operadores
- Relacionales: `==`, `!=`, `<`, `<=`, `>`, `>=`
- Lógicos: `||` (OR), `&&` (AND), `!` (NOT)

### Funciones Especiales
- `ASC(palabra)`: Ordena ascendentemente
- `DESC(palabra)`: Ordena descendentemente
- `REVERSE(palabra)`: Invierte la palabra
- `CARACTER_ALEATORIO()`: Retorna carácter a-z/A-Z
- `NUM_ALEATORIO()`: Retorna número 0-9
- `ALERT_INFO(mensaje)`: Muestra alerta
- `EXIT()`: Termina ejecución
- `REDIRECT()`: Redirige página

## 📖 Ejemplo de Uso

```html
<!-- Mi primer captcha
       en el curso de Organización de Lenguajes y Compiladores 1
       -->
<C_CC [id="captcha_matematico_2" ] [name="Captcha Matemático 1" ]>
   !! El encabezado de la página que tendrá mi captcha
   <C_HEAD>
       <C_LINK !! El link al que redirige mi captcha
           [href="https://www.mclibre.org/consultar/htmlcss/html/html-etiquetas.html" ]>
       </C_LINK>
       !! El título de mi página
       <C_TITLE> Mi primer Captcha Matemático</C_TITLE>
   </C_HEAD>
   !! El cuerpo de la página
   <C_BODY [background="#e5e6ea" ]>
       !! un título simple estilizado
       <C_H1 [id="title_1" ] [text-align="center" ] [color="#7eff33" ]> Mi primer Captcha Matemático
       </C_H1>
       !! Un salto normal
       <C_BR />
       !! Información de la operación a resolver en el captcha
       <C_SPAM [id="mostrar_1" ] [text-align="center" ] [color="#3366ff" ]> ¿ Qué resultado genera la operación
           siguiente: 5+5 ?
       </C_SPAM>
       !! Input para la Respuesta del usuario generado con un scripting
       <C_SCRIPTING>
           ON_LOAD () [
           !!Estas instrucciones se ejecutan media vez se entra al scripting
           !! Insertamos el input con sus parámetros con la instrucción INSERT
           INSERT('<C_INPUT [type="text" ] [text-align="center" ] [id="entrada_1" ]>');
               INSERT('</C_INPUT>');
           ]
       </C_SCRIPTING>
       !! Boton que llama a la funcionalidad calc
       <C_BUTTON [id="boton_1" ] [onclick="FUNCTION_calc()" ] [background="green" ]> Procesar...
       </C_BUTTON>
       !! Scripting para la función calc
       <C_SCRIPTING>
           FUNCTION_calc() [
           !! Estas instrucciones no se ejecutan hasta llamar a FUNCTION_calc()
           integer @global contador_fallas = 5;
           string result_caja_texto = getElementById('entrada_1');
           string result = "10";
           string mensaje_fallo = "El captcha no fue validado intente otra vez ";
           string mensaje_acierto = "El captcha fue validado ";
           string mensaje_final = "El captcha no logró ser validado :( intente mas tarde";
           !! Validacion del numero de oportunidades restantes
           IF (contador_fallas == 0) THEN
           INIT {:
           ALERT_INFO(mensaje_final);
           EXIT();
           :} END
           !! Validación de fallas y aciertos
           IF (result_caja_texto == result ) THEN
           !!si el resultado es correcto
           INIT {:
           ALERT_INFO(mensaje_acierto);
           REDIRECT();
           :} END
           ELSE
           !!si el intento es incorrecto
           INIT {:
           ALERT_INFO(mensaje_fallo);
           contador_fallas = contador_fallas - 1;
           :} END
           ]
       </C_SCRIPTING>
   </C_BODY>
</C_CC>
!! Fin de estructura CC


```

## 📝 Licencia
[Agregar licencia del proyecto]

## 👥 Contribuir
[Instrucciones para contribuir al proyecto]