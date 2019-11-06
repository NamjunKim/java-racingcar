# 2단계 - 자동차 경주

## 기능 요구사항

- 초간단 자동차 경주 게임을 구현한다.  
  -> 자동차가 필요하다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.  
  -> 차에는 달리기 기능과 멈추는 기능이 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.  
  -> 게임이 참여할 자동차 수를 입력할 수 있어야 한다.  
  -> 몇 번 이동할지 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.  
  -> 0-9의 숫자중 랜덤으로 4이상이 나오면 해당 한칸 이동함
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.  
  -> 출발선에서 표시, 모든 차들이 랜덤한 값을 모두 확인하였을때 표시

### 추가 기능 요구사항

- 입력값 검증  
        - 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw  
        - 입력받는 항목이 숫자가 아닌 경우 IllegalArgumentException throw  

### 힌트

- 값을 입력 받는 API는 Scanner를 이용한다.  
- 랜덤 값은 자바 java.util.Random 클래스의 nextInt(10) 메소드를 활용한다.  
  -> 랜덤 유틸 구현
- 기본 뼈대 클래스는 다음 코드로부터 시작할 수 있다. 배열을 사용하는 것이 싫다면 ArrayList를 사용하는 것도 좋은 방법이다.  

```RacingGame sample
public class RacingGame {
    private int time;
    private int[] carPositions = {0, 0, 0};

    public int[] move() {
      // TODO 구현
    }
}
```

### 프로그래밍 요구사항

- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    (참고문서: <https://google.github.io/styleguide/javaguide.html> 또는 <https://myeonguni.tistory.com/1596)>
- else 예약어를 쓰지 않는다.
        - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
        - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

### 기능 목록 및 commit 로그 요구사항

- 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    (참고문서: AngularJS Commit Message Conventions)
dafsadfds
- AngularJS Commit Message Conventions 중 commit message 종류를 다음과 같이구분

```AngularJS Commit Message Conventions
    feat (feature)
    fix (bug fix)
    docs (documentation)
    style (formatting, missing semi colons, …)
    refactor
    test (when adding missing tests)
    chore (maintain)
```