<h1>2025-06-02</h1>
<strong>Theme 💭 </strong>
<small>Comparable</small>

<br/>
<h2>개념</h2>

- **정렬과 Comparable**

- **Arrays.sort() vs Collections.sort() 차이**

- **Comparable이란**


<br/>
<h2>정리</h2>

### Comparable이란

- 자기 자신과 다른 객체를 비교할 수 있도록 해주는 인터페이스

```java

    public interface Comparable<T> {
        int compareTo(T o);
    }

```


- 예시

```java

    class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 나이 오름차순 정렬
    @Override
    public int compareTo(Person other) {
            return Integer.compare(this.age, other.age);
        }
    }

```

- **팁.** 실제로는 compare의 순서를 외우기 보다는 일단 해보고 틀리면 바꿔라.

<br>

- 문자열 비교와 날짜/시간 비교도 마찬가지.

```java

    // 기존 사전 오름차순
    String a = "apple";
    String b = "banana";

    int result = a.compareTo(b); // 음수 → a < b

    // 반대는 b.compareTo(b)로 sort()에 Comparator 객체 전달하면 됨

```

<br>

- 사용자 정의 객체 비교

```java

    list.sort(Comparator.comparing((Person p) -> p.age, Comparator.reverseOrder())
                        .thenComparing(p -> p.name));

```

<br>

---

### 정렬과 Comparable

- 2차원 배열 정렬

```java

    // n번째 열 기준 오름차순 정렬
    Arrays.sort(arr, Comparator.comparingInt(a -> a[n]));

    Arrays.sort(arr, (a,b) -> Integer.compare(a[n], b[n]));

    // n번째 열 기준 내림차순 정렬
    Arrays.sort(arr, (a,b) -> Integer.compare(b[n], a[n]));

    // 기준을 여러 개 정하자
    Arrays.sort(arr, (a, b) -> {
        if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
        return Integer.compare(a[0], b[0]);
    });

```

- `Integer.compare`는 숫자 두 개를 받아서 비교하는 함수

- Comparator.comparingInt()는 어떤 값을 기준으로 비교할지 정렬 기준을 추출하는 함수 -> 정렬해주는 Comparator 객체 반환

- sort의 두 번째 매개변수는 Comparator<T> 타입 객체를 받는다. 따라서 람다식으로 직접 Comparator를 구현하거나 Comparator 객체 생성

<br>

---

### Arrays.sort() vs Collections.sort() 차이

| 항목     | `Arrays.sort()`                                  | `Collections.sort()`                         |
| ------ | ------------------------------------------------ | -------------------------------------------- |
| 대상     | `배열 (int[], String[], Object[])`                 | `리스트` (`ArrayList`, `LinkedList` 등)         |
| 위치     | `java.util.Arrays` 클래스                           | `java.util.Collections` 클래스                  |
| 정렬 기준  | 기본 정렬 or `Comparator` 전달                         | 기본 정렬 or `Comparator` 전달                     |
| 시간 복잡도 | `Dual-Pivot Quicksort`, `Timsort`, `MergeSort` 등 | 내부적으로 **Timsort**                            |
| 사용 예   | `Arrays.sort(arr)`                               | `Collections.sort(list)` 또는 `list.sort(...)` |

- 배열 정렬의 경우, 자료형에 따라 상황에 따라 정렬 알고리즘이 달라진다고 알고 있다.

- 팀 정렬은 병합 정렬과 삽입 정렬을 합친 것으로, 이미 정렬된 구간을 감지해 병합만 수행하고 작은 구간은 삽입 정렬로 처리한다. 안정 정렬이며 빠르다!