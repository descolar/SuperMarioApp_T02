# Super Mario App

Esta aplicación Android muestra un listado de personajes de **Super Mario Bros** y permite ver los detalles de cada uno. La aplicación utiliza **RecyclerView** y **CardView** para listar personajes y emplea un **Navigation Drawer** para navegar entre secciones como "Home" y "Settings".

## Características

- **Listado de Personajes**: Muestra una lista de personajes de Super Mario (Mario, Luigi, Peach, Toad) usando `RecyclerView` y `CardView`, incluyendo imagen y nombre de cada personaje.
- **Pantalla de Detalles**: Al seleccionar un personaje, se abre una nueva pantalla con información detallada sobre el personaje, como una descripción y sus habilidades especiales.
- **Cambio de Idioma**: Soporte para inglés y español. Incluye un `Switch` en la pantalla de ajustes para cambiar el idioma de la aplicación.
- **Menú Lateral (Navigation Drawer)**: Un menú lateral que permite acceder a "Home" y "Settings".
- **Pantalla de Splash**: Muestra una pantalla de bienvenida con el logo de la aplicación durante unos segundos al iniciar.
- **Snackbar y Toast**: Incluye un `Snackbar` con un mensaje de bienvenida y un `Toast` que indica el personaje seleccionado al abrir la pantalla de detalles.
- **Menú de "Acerca de"**: En la barra superior, se encuentra un menú con una opción "Acerca de" que muestra un `AlertDialog` con información sobre el desarrollador y la versión de la app.

## Componentes Clave

- **RecyclerView**: Utilizado para mostrar el listado de personajes con un diseño atractivo y clicable.
- **CardView**: Cada personaje en el listado está contenido en una `CardView` que incluye una imagen y el nombre del personaje.
- **SharedPreferences**: Almacena la preferencia de idioma seleccionada por el usuario.
- **View Binding**: Facilita el manejo seguro y limpio de las vistas de la aplicación.

## Capturas de Pantalla
- **ScreenSplash
  ![image](https://github.com/user-attachments/assets/a158b42e-363d-4910-98a7-7e967111eb4e)

- **Pantalla Principal**: Lista de personajes de Super Mario.
- ![image](https://github.com/user-attachments/assets/e6734a7f-afae-4b3f-9a35-10b521fecb70)

- **Menú Lateral**: Opciones de "Home" y "Settings".
- ![image](https://github.com/user-attachments/assets/10132625-9f40-4e22-8987-6bcfb5b708c1)

- **Pantalla de Detalles**: Información completa del personaje seleccionado.
- ![image](https://github.com/user-attachments/assets/5f080f5b-c5c5-4c28-addb-79860acbfb5c)

- **Pantalla de Ajustes**: Cambio de idioma entre español e inglés.
- ![image](https://github.com/user-attachments/assets/03c5511e-6548-4142-84f7-acd2d1208ed7)

- **Dialogo "Acerca de"**: Información sobre el desarrollador y la versión.
- ![image](https://github.com/user-attachments/assets/bd0f2275-f124-4dbd-89e4-9b55312a9448)

