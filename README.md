# Certificacion Instructores 111MIL

Proyecto para certificar como instructor del 111Mil de Rotatori Gisela

En el directorio se encontrara:

- Todo lo relacionado al proyecto:
  - Modelo
  - Vista
  - Controlador
  - DAO (Hibernate)
  - Librerías utilizadas
- Archivos extras solicitados
  - Diagrama de Clases
  - Diagrama de secuencia
  - Script de creacion de base de datos con información almacenada

## Breve explicación del Caso de uso resuelto

Ni bien iniciado el programa se encontrará con una pantalla de Inscripción a cursos. Dicha pantalla está dividida en dos:
  - Primer parte para buscar al participante en la base de datos (si es que esta inscripto)
  - Segunda parte donde se pueden buscar los cursos por temática y ver información relacionada a los mismos (profesor, cupos, carga horaria, duracion, etc.)

### Primera parte del formulario de inscripción a curso
Se cuenta con un campo de texto en donde se pondrá un mail y un botón de buscar que buscará el participante dentro de la base de datos. En caso de no encontrarlo, se abrirá una ventana de registro donde se le pide al usuario:
  - Nombre
  - Apellido
  - Telefono
  - Email (en este caso el campo se autocompleta con el mail puesto en el formulario de inscripción a cursos)
  - Fecha de nacimiento
    - En caso de ser menor de edad se solicita que se ingrese nombre del padre/madre o tutor
Una vez completado el registro se vuelve a la pantalla de inscripción a curso y se traen los datos del participante (Si ya estaba registrado se trae desde la base de datos y sino mediante el formulario de registro).

### Segunda parte del formulario de inscripción a curso
Una vez cargada la informacion del participante, se puede proceder a inscribirse. Para esto el usuario cuenta con un selector donde puede seleccionar la temática que desee y le apareceran en una tabla los cursos correspondientes a esa temática. 
Selecciona el curso que desee y presiona el boton inscribir.
El sistema verifica que el participante pueda inscribirse al curso (comprobando a cuántos cursos está inscripto, si está en 3 cursos no le permite inscribirse a otro). También se verifica el cupo disponible del curso, ya que si no hay cupo el participante se inscribe como condicional (tiene que esperar a que alguien se de de baja para poder tener una inscripción efectiva)
Una vez hecha todas las validadiones, se le informa al participante que fue inscripto de manera exitosa.

## Diagrama de clases
Se tuvieron utiliazaron 7 clases en la capa modelo:
  - Persona <<abstracta>>
  - Participante
  - Profesor
  - Curso
  - Inscripcion
  - Tematica
  - Condicion

## Diagrama de secuencia
Para el diagrama de secuencia se tuvieron en cuenta la capa de vista (considerando los Frames como objetos) y la capa de controladoras, cabe aclarar que desde la capa de controladoras se llama a la capa de DAO, pero por tema de prolijidad en el diagrama se excluyo.
