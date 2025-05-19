
![banner](./README-Banner.png)

### To auth

```
curl -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d "{\"username\":\"admin\", \"password\":\"password\"}"
```

result:
```json
{"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE3NDc2NTAwNTIsImV4cCI6MTc0NzY1MzY1Mn0.oSSkjyWxJ14WuR7w-vsZyEN31n4SbbvgHVUwmjwA-RM"}
```

## To check security

```
curl "http://localhost:8080/secured/data" -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE3NDc2NTA1MDksImV4cCI6MTc0NzY1NDEwOX0.rJ8wE6tW4jxhcLntVl2nxDIIpdM2hzLEQXtKJOtkSiw"
```

result:
```json
{"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJpYXQiOjE3NDc2NTAwNTIsImV4cCI6MTc0NzY1MzY1Mn0.oSSkjyWxJ14WuR7w-vsZyEN31n4SbbvgHVUwmjwA-RM"}
```

logs:
```
2025-05-19T18:28:58.667+08:00  INFO 12092 --- [spring-security-JWT-2025] [nio-8080-exec-2] c.e.s.JwtAuthenticationFilter            : User: admin
2025-05-19T18:28:58.667+08:00  INFO 12092 --- [spring-security-JWT-2025] [nio-8080-exec-2] c.e.s.JwtAuthenticationFilter            : Roles: [ROLE_USER]
2025-05-19T18:28:58.667+08:00  INFO 12092 --- [spring-security-JWT-2025] [nio-8080-exec-2] c.e.s.JwtAuthenticationFilter            : Expires: Mon May 19 19:28:29 SGT 2025
```

logs - simplified:
```
User: admin
Roles: [ROLE_USER]
Expires: Mon May 19 19:28:29 SGT 2025
```

- notice that the token expires in 1 hour