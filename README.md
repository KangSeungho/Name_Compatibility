# 이름 궁합 앱
사용 기술
```
- Kotlin
- MVVM
- Clean Architecture
- Dagger Hilt
- Retrofit + Okhttp
- Coroutine
- Kotlin DSL
- Firebase Realtime Database
```

## Dagger Hilt
의존성 주입(Dependency Injection)을 쉽게 하기 위해 도와주는 라이브러리입니다.

### 의존성 주입이란?
- 객체의 생성을 클래스 내부에서 하는게 아니라 클래스 외부에서 객체를 생성하여 주입시켜주는 디자인 패턴입니다.

ex) 의존성을 갖는 상태
```
class B {
    val id = "newtopia"
}

class A {
    val data = B()        // 의존 관계 생성
}

>>> println(A().data.id)  // A 클래스는 B 클래스에 의존적이게 된다.
```

ex) 의존성 주입한 상태
```
class B {
    val id = "newtopia"
}

class A(b: B) {
    val data = b
}

>>> val b = B()           // 외부에서 객체 생성
>>> println(A(b).data.id) // 외부에서 생성된 객체를 주입
```

### 의존성 주입의 장점
- 외부에서 객체를 생성해서 주입하기 때문에 코드의 재사용성이 높습니다.
- 테스트에 용이합니다.
- 의존성이 낮아지기 때문에 코드 변경에 유연하고 자유롭습니다.
- 앱 생명주기에 따라 관리되어 적절한 시점에 필요한 객체들이 자동으로 주입됩니다.
- 보일러 플레이트가 대폭 줄어듭니다.


## Kotlin DSL
Kotlin DSL(Domain Specific Language)은 코틀린의 언어적인 특징으로 가독성이 좋고 간략한 코드를 사용하여 Gradle 스크립팅을 하는 것을 목적으로 하는 DSL이다.

### 장점
- IDE 지원 향상된 편집 환경
- Code highlighting
- 자동완성 지원
- 오류 코드 강조
- 변수 리펙토링 가능
- 익숙한 Kotlin 언어 사용으로 러닝 커브 낮음
- 멀티 모듈 사용 시 중복 의존성 선언 필요 없어짐

### 단점
- 빌드 캐시가 Invalidation 되거나 클린 빌드 시에 Groovy DSL보다 느림
- 새로운 라이브러리 버전 Inspection 기능 미지원
