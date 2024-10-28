# CaptchaForge - Manual Técnico

## 🎯 Descripción

CaptchaForge es un sistema intérprete que permite la traducción de código basado en etiquetas a páginas web funcionales. El sistema tiene la capacidad de procesar código de alto nivel embebido en cualquier parte del documento y traducirlo a lenguajes web estándar (HTML, JavaScript, CSS) utilizando Angular para implementar el dinamismo requerido.

### Característica Principal
> "Se busca que estos sean traducidos a páginas web reales independientes y las cuales deberán ser desplegadas por un servidor web de acuerdo al lenguaje que se utiliza en la implementación."

### Objetivo del Intérprete
> "Se le pide implementar un intérprete que permita la traducción de un código basado en etiquetas el cual puede tener además codigo de alto nivel embebido en cualquier parte del documento, a un lenguaje entendido por los navegadores web en este caso hablamos de lenguaje HTML además de las configuraciones necesarias y el dinamismo agregado mediante lenguajes como JavaScript, CSS y Angular."

## 📊 Diagramas del Sistema

### 1. Flujo de Generación de Captcha
```mermaid
graph TD
    A[Inicio] --> B[Abrir/Crear archivo .cc]
    B --> C[Editar código CC]
    C --> D[Análisis Léxico]
    D --> E[Análisis Sintáctico]
    E --> F[Análisis Semántico]
    F --> G{¿Errores?}
    G -->|Sí| H[Mostrar errores]
    H --> C
    G -->|No| I[Generar código HTML/JS/CSS]
    I --> J[Crear página web del captcha]
    J --> K[Almacenar información del captcha]
    K --> L[Generar link de acceso]
    L --> M[Fin]
```

### 2. Flujo de Análisis
```mermaid
graph TD
    A[Inicio Análisis] --> B[Identificar etiquetas CC]
    B --> C[Analizar parámetros de etiquetas]
    C --> D[Identificar bloques de scripting]
    D --> E[Analizar código CLC dentro de scripting]
    E --> F[Verificar funciones especiales]
    F --> G[Comprobar declaraciones y asignaciones]
    G --> H[Analizar estructuras de control]
    H --> I[Verificar instrucciones INSERT]
    I --> J[Fin Análisis]
```

### 3. Flujo de Conversión CC a HTML
```mermaid
graph TD
    A[Inicio Generación] --> B[Crear estructura HTML básica]
    B --> C[Generar HEAD con título y enlaces]
    C --> D[Generar BODY con estilos]
    D --> E[Insertar elementos UI basados en etiquetas CC]
    E --> F[Generar código JavaScript para funcionalidad]
    F --> G[Insertar código de validación del captcha]
    G --> H[Agregar estilos CSS]
    H --> I[Fin Generación]
```

### 4. Diagrama de Interacciones
```mermaid
graph TD
    A((Usuario)) --> B(Crear/Editar código CC)
    A --> C(Generar Captcha)
    A --> D(Usar Captcha)
    A --> E(Ver Reporte de Utilización)
    A --> F(Ver Reporte de Errores)
    A --> G(Ver Tabla de Símbolos)
    B --> H{Sistema CC}
    C --> H
    D --> H
    E --> H
    F --> H
    G --> H
```

### 5. Diagrama de Actividades
```mermaid
graph TD
    A[Inicio] --> B[Crear/Editar código CC]
    B --> C{Errores de compilación?}
    C -->|Sí| D[Mostrar Reporte de Errores]
    D --> B
    C -->|No| E[Generar Captcha]
    E --> F[Mostrar Captcha generado]
    F --> G[Usuario intenta resolver Captcha]
    G --> H{Captcha resuelto correctamente?}
    H -->|Sí| I[Redirigir a página destino]
    H -->|No| J{Intentos restantes?}
    J -->|Sí| G
    J -->|No| K[Mostrar mensaje de fallo]
    I --> L[Fin]
    K --> L
```

### 6. Diagrama de Secuencia
```mermaid
sequenceDiagram
    actor Usuario
    participant Editor
    participant Intérprete
    participant GeneradorCaptcha
    participant PáginaWeb
    Usuario->>Editor: Crea/Edita código CC
    Editor->>Intérprete: Envía código CC
    Intérprete->>Intérprete: Analiza código (léxico, sintáctico, semántico)
    alt Errores encontrados
        Intérprete->>Editor: Devuelve reporte de errores
        Editor->>Usuario: Muestra errores
    else Sin errores
        Intérprete->>GeneradorCaptcha: Envía instrucciones
        GeneradorCaptcha->>PáginaWeb: Genera Captcha
        PáginaWeb->>Usuario: Muestra Captcha
        loop Intentos de resolución
            Usuario->>PáginaWeb: Intenta resolver Captcha
            PáginaWeb->>PáginaWeb: Verifica respuesta
            alt Captcha resuelto
                PáginaWeb->>Usuario: Redirige a página destino
            else Captcha no resuelto
                PáginaWeb->>Usuario: Muestra mensaje de error
            end
        end
    end
```