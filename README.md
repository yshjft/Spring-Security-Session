# Spring Security Session

#### Spring Security에 대한 이해를 위해 Session 기반 로그인을 구현합니다

## 기술 스택
- Spring Boot
- Spring Security
- h2
- redis

## API
빠르게 끝내기 위해 간단하게 만들었습니다.

* [POST] /api/user/signup   
  * REQUEST
    ```
    {
        "email": "test1@email.com",
        "password": "test1",
        "name": "test1",
        "authorities": [
            "ROLE_USER"
        ]
    }
    ```


  * [POST] /api/auth/login
    * REQUEST

    ```
    {
      "email": "test1@email.com",
      "password": "test1"
    }
    ```
    
  * [POST] /api/auth/logout    

  
  * [GET] /api/user
    * ROLE_USER
    * ROLE_ADMIN


  * [GET] /api/user/all
    * ROLE_ADMIN