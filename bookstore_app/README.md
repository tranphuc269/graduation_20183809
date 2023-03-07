# BookStore app

Mô phỏng ứng dụng thương mại điện tử trên mobile.

## Work Flow

![alt text](screenshots/Clean-Architecture-Flutter-Diagram.png?raw=true)

## Cấu trúc thư mục

<img align="left" src="screenshots/folder_structure.png"></img>

```
    lib
    ├── app
    │   ├── config
    │   │   └── (...)
    │   ├── core
    │   │   └── usecases
    │   │       ├── no_param_usecase.dart
    │   │       └── pram_usecase.dart
    │   ├── extensions
    │   │   └── color.dart
    │   ├── services
    │   │   └── local_storage.dart
    │   ├── types
    │   │   ├── category_type.dart
    │   │   └── tab_type.dart
    │   └── util
    │       ├── dependency.dart
    │       └── util.dart
    ├── data
    │   ├── models
    │   │   └── (...)
    │   ├── providers
    │   │   ├── database
    │   │   │   └── firebase_database_provider.dart
    │   │   └── network
    │   │       ├── apis
    │   │       │   ├── article_api.dart
    │   │       │   └── auth_api.dart
    │   │       └── (...)
    │   └── repositories
    │       ├── article_repository.dart
    │       └── auth_repository.dart
    ├── domain
    │   ├── entities
    │   │   └── (...)
    │   ├── repositories
    │   │   └── (..)
    │   └── usecases
    │       └── (...)
    ├── presentation
    │   ├── controllers
    │   │   ├── auth
    │   │   ├── headline
    │   │   └── news
    │   ├── pages
    │   │   ├── detail
    │   │   ├── headline
    │   │   ├── home
    │   │   ├── news
    │   │   └── profile
    │   │
    │   └── app.dart
    ├── generated_plugin_registrant.dart
    └── main.dart
```

## Features

- Integrating Unit Test.
- Create an easy to use API provider with [GetConnect](https://github.com/jonataslaw/getx#getconnect).
