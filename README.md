# TP4
[README (2).md](https://github.com/user-attachments/files/28123527/README.2.md)
# TP3 - Índice de Estudiantes usando Tabla Hash con Listas Enlazadas

## Descripción

Implementación de un módulo de indexación basado en una **Tabla Hash con encadenamiento** para el sistema de gestión académica universitaria desarrollado en los TPs anteriores.

El índice permite insertar, buscar y eliminar estudiantes por su **DNI** de forma eficiente, usando una función de dispersión multiplicativa sobre strings y resolución de colisiones mediante **listas enlazadas en cada posición** de la tabla.

---

## Objetivos

- Implementar una Tabla Hash con listas enlazadas para resolver colisiones
- Aplicar una función de dispersión multiplicativa sobre strings
- Implementar eliminación lógica mediante bandera booleana
- Respetar un factor de carga máximo de 0.75
- Integrar el índice en la clase Universidad

---

## Estructura del Proyecto

```
├── Persona.java           # Clase madre con atributos base
├── Estudiante.java        # Hereda de Persona, incluye materias y promedio recursivo
├── Profesor.java          # Hereda de Persona, incluye materias asignadas
├── Personal1.java         # Hereda de Persona, incluye datos laborales
├── Materia.java           # Clase con datos de materia y referencia al profesor
├── Carrera.java           # Gestiona lista de estudiantes por carrera
├── Universidad.java       # Clase principal que integra todas las estructuras
├── Elemento.java          # Nodo de la lista enlazada dentro de la tabla hash
├── indiceEstudiante.java  # Tabla Hash con listas enlazadas
└── APP.java               # Main con menú interactivo
```

---

## Implementación de la Tabla Hash

### Parámetros

| Parámetro | Valor |
|-----------|-------|
| Tamaño de la tabla | 29 (número primo) |
| Factor de carga máximo | 0.75 |
| Resolución de colisiones | Listas enlazadas (encadenamiento) |
| Eliminación | Lógica (bandera booleana) |

---

## Funcionamiento Interno

### Clase Elemento (Nodo)

Cada posición de la tabla contiene una lista enlazada de nodos `Elemento`:

```java
public class Elemento {
    private Estudiante es;     // el estudiante almacenado
    private Elemento sgte;     // puntero al siguiente nodo
    private boolean esaob;     // true = activo, false = eliminado lógicamente
}
```

### Transformación de Clave

Convierte el DNI string en un número largo sumando dígito a dígito:

```java
public long Transformarclave(String n){
    long d = 0;
    for(int i = 0; i < n.length(); i++){
        d = d * 10 + ((int)n.charAt(i) - '0');
    }
    return d;
}
```

### Función de Dispersión Multiplicativa

Usa la constante de Knuth (0.6180) para distribuir uniformemente los elementos:

```java
public int Dispersion(long x){
    double r = 0.6180;
    double t = r * x - Math.floor(r * x);
    return (int)(tamaño * t);
}
```

### Inserción con Encadenamiento

Cuando hay colisión, el nuevo elemento se inserta al inicio de la lista enlazada en esa posición:

```java
public void insertar(String legajo, Estudiante es){
    int indice = hash(legajo);
    Elemento nuevo = new Elemento(es);
    nuevo.setSgte(tabla[indice]); // apunta al elemento que estaba antes
    tabla[indice] = nuevo;        // pasa a ser la nueva cabeza
}
```

### Eliminación Lógica

En vez de borrar físicamente el nodo, se marca con `esaob = false`:

```java
aux.setnegaresaob(); // marca como eliminado sin borrar el nodo
```

Esto evita romper la cadena de búsqueda.

---

## Tabla de Trabajo

### Cálculo de clave y posición

**12345678** → clave = 12345678 → dispersión → posición X

**87654321** → clave = 87654321 → dispersión → posición Y

| DNI      | Clave (long) | Posición h(k) | ¿Colisión? | Resolución         |
|----------|--------------|---------------|------------|--------------------|
| 12345678 | 12345678     | 18            | No         | Inserta directo    |
| 87654321 | 87654321     | 10            | No         | Inserta directo    |
| 11223344 | 11223344     | 3             | No         | Inserta directo    |
| 44332211 | 44332211     | 25            | No         | Inserta directo    |
| 99887766 | 99887766     | 16            | No         | Inserta directo    |
| 55667788 | 55667788     | 18            | Sí         | Encadena en pos 18 |
| 33221100 | 33221100     | 3             | Sí         | Encadena en pos 3  |

Factor de carga: 7/29 = 0.24 ✅ (menor a 0.75)

---

## Menú del Sistema

```
1  - Agregar carrera a la facultad
2  - Agregar estudiante
3  - Cargar una materia a un estudiante (busca por DNI)
4  - Mostrar carreras de la facultad
5  - Listar alumnos según la carrera
6  - Mostrar alumno por nombre
7  - Agregar un profesor
8  - Ver profesores en la facultad
9  - Agregar materias a profesores
10 - Agregar un empleado de personal
11 - Listar los empleados de personal
12 - Buscar estudiante por DNI (Tabla Hash)
13 - Mostrar tabla hash completa
14 - Eliminar estudiante por DNI
15 - Salir
```

---

## Reflexión

### ¿Dónde hubo más colisiones?
Las colisiones ocurrieron en las posiciones 18 y 3, donde dos DNIs distintos generaron el mismo índice de dispersión. Con el encadenamiento esto no es un problema ya que cada posición puede almacenar múltiples elementos en una lista enlazada.

### ¿Qué tan eficiente fue la resolución de colisiones?
El encadenamiento con listas enlazadas es muy eficiente cuando el factor de carga es bajo. La búsqueda en el peor caso recorre todos los elementos de una misma posición, pero con un tamaño primo de 29 y factor de carga menor a 0.75, las listas son cortas y la búsqueda es casi inmediata.

### ¿Qué pasaría si el tamaño no fuera primo?
Si el tamaño no fuera primo, la función de dispersión multiplicativa distribuiría peor los elementos, generando más colisiones y listas más largas en ciertas posiciones. El tamaño primo 29 garantiza una distribución más uniforme y listas enlazadas más cortas en cada posición.

---

## Tecnologías

- Java
- Programación Orientada a Objetos
- Estructuras de Datos (Tabla Hash + Listas Enlazadas)

---

## Autor

Ingeniería en Sistemas de Software
