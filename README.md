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
![Screenshot_20241116_160944](https://github.com/user-attachments/assets/373588fc-7de4-4ece-81dc-46ece2afc37a)


- **Pantalla Principal**: Lista de personajes de Super Mario.
![Screenshot_20241116_161006](https://github.com/user-attachments/assets/e4ea0af8-6a82-4a8e-8a5e-3e4ac2a6f976)


- **Menú Lateral**: Opciones de "Home" y "Settings".
![Screenshot_20241116_161027](https://github.com/user-attachments/assets/80a2ed2b-f738-4e95-b0e3-50a34d0774cb)


- **Pantalla de Detalles**: Información completa del personaje seleccionado.
![Screenshot_20241116_161251](https://github.com/user-attachments/assets/93280aec-d353-49e7-a177-b74f3c09ce65)
![Screenshot_20241116_161302](https://github.com/user-attachments/assets/53910929-6e7d-4ae0-aa64-495c2a27dd77)


- **Pantalla de Ajustes**: Cambio de idioma entre español e inglés.
![Screenshot_20241116_161033](https://github.com/user-attachments/assets/d550f7ff-a0bc-4c33-928e-f74339ae5e5b)


- **Dialogo "Acerca de"**: Información sobre el desarrollador y la versión.
![Screenshot_20241116_161017](https://github.com/user-attachments/assets/b10b3e6d-ee7e-4f3e-83fd-dd11f8093832)


