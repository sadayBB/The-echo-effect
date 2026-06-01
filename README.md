# The Echo Effect

Proyecto Android nativo (Kotlin + Jetpack Compose) para avance universitario (75%).

## 1) Resumen y título del proyecto
- **Título:** The Echo Effect
- **Estudio:** Moonless Studio
- **Resumen:** Juego narrativo oscuro donde las decisiones del jugador alteran afinidad y tensión del Echo.

## 2) Avances logrados
- Proyecto Android nativo funcional con Gradle.
- Navegación Compose operativa entre pantallas.
- Botones funcionales en todas las pantallas clave.
- Persistencia con SharedPreferences para progreso básico.

## 3) Pantallas funcionales implementadas
1. SplashScreen
2. StartMenuScreen
3. CharacterSelectionScreen
4. GameScreen
5. EchoStatusScreen
6. CreditsScreen

## 4) Estructura de código (rúbrica)
- Herencia de personajes:
  - `CharacterBase`
  - `MaleEchoCharacter`
  - `FemaleEchoCharacter`
- Jerarquía de decisiones:
  - `EchoChoice`
  - `MercyChoice`, `ResolveChoice`, `BalanceChoice`, `RuinChoice`
- Sobrecarga de constructor:
  - `CharacterBase(displayName: String)`
  - `EchoState(primaryAffinity: EchoAffinity, tension: Int)`
- Sobrecarga de métodos:
  - `updateEcho(choice: EchoChoice)`
  - `updateEcho(affinity: EchoAffinity, tensionAmount: Int)`

## 5) Persistencia de datos
`GamePreferences.kt` guarda:
- Nombre del jugador
- Personaje seleccionado
- Última pantalla
- Afinidad principal
- Tensión del Echo
- Puntos por afinidad
- Estado de sonido (bandera preparada)

## 6) Estructura y relación de clases (UML simplificado)
```text
CharacterBase
 ├─ MaleEchoCharacter
 └─ FemaleEchoCharacter

EchoChoice
 ├─ MercyChoice
 ├─ ResolveChoice
 ├─ BalanceChoice
 └─ RuinChoice

EchoState --> EchoAffinity
GamePreferences --> EchoState
```

## 7) Pendientes del 25% restante
- Integrar escenas narrativas múltiples con ramas persistentes.
- Añadir SettingsScreen visual y control de sonido en UI.
- Incorporar inventario/flags de historia.
- Mejorar arte/animaciones/efectos de sonido.
- Exportar datos de progreso a nube (si aplica).

## 8) Retos y resolución
- **Reto:** Partir desde repositorio casi vacío.
- **Resolución:** Se creó una base Gradle Android limpia y modular con Compose y navegación.

## 9) Comentarios adicionales
- Código preparado para Android Studio y edición en VS Code.
- Estructura de paquetes alineada a una práctica académica clara.

## 10) Entrega
- Proyecto listo para comprimir en ZIP.
- Demo funcional con navegación y estado persistente.

## Archivos principales creados
- `app/src/main/java/com/moonlessstudio/theechoeffect/MainActivity.kt`
- `app/src/main/java/com/moonlessstudio/theechoeffect/navigation/AppNavigation.kt`
- `app/src/main/java/com/moonlessstudio/theechoeffect/navigation/Routes.kt`
- `app/src/main/java/com/moonlessstudio/theechoeffect/ui/screens/*`
- `app/src/main/java/com/moonlessstudio/theechoeffect/ui/components/*`
- `app/src/main/java/com/moonlessstudio/theechoeffect/model/*`
- `app/src/main/java/com/moonlessstudio/theechoeffect/data/GamePreferences.kt`
- `app/src/main/java/com/moonlessstudio/theechoeffect/ui/theme/*`

## Cómo ejecutar
### Linux / macOS
```bash
./gradlew assembleDebug
```

### Windows
```bat
gradlew.bat assembleDebug
```

## APK esperado
`app/build/outputs/apk/debug/app-debug.apk`
