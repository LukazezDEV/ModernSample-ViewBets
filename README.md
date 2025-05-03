---

# 📱 ViewBetsApp

**A cleanly architected Android app to explore sports betting data, built with best practices and modern libraries.**

---

## 🚀 Features

* 🧠 **MVVM + Clean Architecture** (UI ➜ Domain ➜ Data)
* ⚡ **Kotlin Coroutines** & **StateFlow** for reactive state management
* 🌍 **Translation-ready enums** using `@StringRes`
* 🔌 **Koin DI** for modular, testable components
* 🌐 **Ktor Client** for scalable, typed network requests
* 🎨 **Jetpack Compose UI**
* 🧪 Logic isolated in pure functions for easy testing

---

## 🛠 Tech Stack

| Layer      | **Q2-2025-Ready Architecture**                 |
|------------|------------------------------------------------|
| UI         | Jetpack Compose, StateFlow, ViewModel          |
| DI         | Koin                                           |
| Network    | Ktor, kotlinx.serialization                    |
| Image      | Coil                                           |
| Build      | Gradle with versions .toml, `buildSrc` configs |
| Min SDK    | 24                                             |
| Target SDK | 35                                             |
| Unit test  | Kotest & Junit5                                |
| JVM        | Java 17                                        |

```toml
[versions]
agp = "8.9.2"
kotlin = "2.1.20"
coreKtx = "1.16.0"
appcompat = "1.7.0"
material = "1.12.0"
constraintlayout = "2.2.1"
junitExt = "1.2.1"
espresso = "3.6.1"
coroutines = "1.10.2"
lifecycle = "2.8.7"
compose-material3 = "1.3.2"
compose-bom = "2025.04.01"
activity-compose = "1.10.1"
navigation-compose = "2.8.9"
compose-plugin = "1.7.3"
serialization-json = "1.8.1"
ktor = "3.1.2"
koin = "4.0.4"
coil = "3.1.0"
kotest = "5.9.1"
junit = "5.12.2"
````

```buildSrc/Configs.kt
object Configs{
    const val namespace = "io.github.lukazezdev.viewbetsapp"
    const val minSdk = 24
    const val compileSdk = 35
    const val targetSdk = 35
    val javaVersion = JavaVersion.VERSION_17

    object App{
        const val versionCode = 2
        const val versionName = "2.0-luka"
        const val applicationId = namespace
    }
}
````

---

## 🧱 Architecture

```text
Presentation (ViewModel + UI)
│
├── Domain (Bet, BetType, odds logic)
│
└── Data (DTOs, Repository, RemoteDataSource with Ktor)
```

---

## 🧩 Notable Code Patterns

* 🧼 Enum-to-string mappings for localization via `@StringRes`
* 🧪 Pure domain logic like `calculateOdds()` separated for testability
* 🧩 `buildSrc/Configs.kt` centralizes SDK, version, and namespace settings
* 🧰 Dependency bundles managed through `libs.versions.toml` and alias plugins

---

## 👨‍💻 Why Use This Project?

* 📚 Learn or demonstrate modern Android app structure
* 📦 Use as a base to build your own Compose + Ktor apps
* 🧪 Write unit and integration tests with clear boundaries

---

## 🤝 Contributing

Feel free to fork and adapt this repo. PRs and suggestions welcome!

---

## 👋 About

Built with ❤️ by [Luka](https://github.com/lukazezdev) — always learning, always clean coding.

---
