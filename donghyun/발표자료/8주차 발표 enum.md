## 🤗ENUMS(열거형) 이란?

> 열거형은 서로 관련된 상수를 편리하게 선언하기 위한 것
**여러 상수**를 정의할때 **유용** -> JDK 1.5부터 추가

#### c언어의 열거형보다 더 향상됨(열거형이 갖는 값 뿐만 아니라 타입도 관리)
```
class Card {
    static final int CLOVER = 0;
    static final int HEART = 1;
    static final int DIAMOND = 2;
    static final int SPADE = 3; 
        
    static final int TWO = 0;
    static final int THREE = 1;
    static final int FOUR = 2; 
        
    final int kind;
    final int num;
```

```
class Card {
    enum Kind {CLOVER,HEART,DIAMOND,SPADE} // 열거형 Kind를 정의
    enum Value {TWO,THREE,FOUR} //열거형 Value를 정의
    
    final Kind kind;
    final Value value;
}
```

>**😏C언어에서는 타입이 달라도 값이 같으면 조건식 결과 true**
vs 자바 enum은 타입도 같아야 한다 -> 컴파일 에러

```
 if(Card.CLOVER == Card.TWO) // (C언어)true지만 의미상 false여야함
 if(Card.Kind.CLOVER == Card.Value.TWO) // 컴파일 에러
 
```
>**😂기존의 상수의 문제점**: 
상수의 값 변경시 해당 상수를 참조하는 모든 소스를 다시 컴파일 해야한다
ENUM -> 컴파일 안해도 된다.

---
## 🔥열거형 정의와 사용

### 정의 방법:
**enum 열거형 이름 { 상수명1, 상수명2, ...}**
>ex) enum Direction {EAST,SOUTH, WEST, NORTH}

### 사용 방법:
**'열거형 이름.상수명'**
클래스의 static 변수를 참조하는 것과 동일하다
>ex) dir = Direction.EAST;

```
Class Unit {
	int x,y ; //유닛의 위치
    	Direction dir; // 열거형을 인스턴스 변수로 선언
    
    	void init(){
    		dir = Direction.EAST; // 유닛의 방향을 EAST로 초기화
    	}
}
        
```

>열거형 상수 간에 '==' 비교 가능 equals()가 아니어서 --> **더 빠른 성능**
but, '<' ,'>' 사용 불가능 대신 compareTo() 사용
* compareTo() : 비교대상 같으면 0, 왼쪽이 크면 양수, 오른쪽 크면 음수

```
if(dir == Direction.EAST) {
	x++;
}else if(dir >Direction.WEST){ // 에러 비교연산자 사용 불가능
	...
}else if(dir.compareTo(Direction.WEST) > 0){ //compareTo() 사용 가능
	...
}
```

>Switch문의 조건식에도 사용가능(오타줄이고 보기 간결)

```
void move() {
	switch(dir){
    	case EAST : x++; //Direction.EAST 라고 쓰면 안됨
        break;
        
        case WEST : x--;
        break
        
        ...
        ...
    }
}
```
---
### 🎈ENUM Direction 모든 상수 출력 방법

```
	Direction[] dArr = Direction.values(); // values()는 열거형의 모든 상수를 배열에 담아 반환(컴파일러 자동 추가)
    for(Direction d : dArr)
    	syso(d.name(),d.ordinal()); // ordinal() 열거형 상수가 정의된 순서(0부터 시작)를 정수로 반환
```


>컴파일러 자동 추가해주는 메서드 하나 더 valueOf(String name);
열거형 상수의 이름으로 문자열 상수에 대한 참조 얻을 수 있다

```
Direction d = Direction.valueOf("WEST");
syso(d); //WEST;

```


<table style="border-collapse: collapse; width: 100%;" border="1" data-ke-align="alignLeft">
<tbody>
<tr>
<td style="width: 50%; text-align: center;">메서드</td>
<td style="width: 50%; text-align: center;">설명</td>
</tr>
<tr>
<td style="width: 50%; text-align: center;">T[]&nbsp;values()&nbsp;&nbsp;</td>
<td style="width: 50%; text-align: center;">&nbsp;&nbsp;해당&nbsp;enum&nbsp;타입에&nbsp;정의된&nbsp;상수&nbsp;배열을&nbsp;반환한다.&nbsp;&nbsp;</td>
</tr>
<tr>
<td style="width: 50%; text-align: center;">&nbsp;&nbsp;Class&lt;E&gt;&nbsp;getDeclaringClass()&nbsp;&nbsp;</td>
<td style="width: 50%; text-align: center;">&nbsp;&nbsp;열거형의&nbsp;객체를&nbsp;반환한다.&nbsp;&nbsp;</td>
</tr>
<tr>
<td style="width: 50%; text-align: center;">&nbsp;&nbsp;String&nbsp;name()&nbsp;&nbsp;</td>
<td style="width: 50%; text-align: center;">&nbsp;&nbsp;열거형&nbsp;상수의&nbsp;이름을&nbsp;문자열로&nbsp;반환한다.&nbsp;&nbsp;</td>
</tr>
<tr>
<td style="width: 50%; text-align: center;">&nbsp;&nbsp;int&nbsp;ordinal()&nbsp;&nbsp;</td>
<td style="width: 50%; text-align: center;">&nbsp;&nbsp;열거형&nbsp;상수가&nbsp;정의된&nbsp;순서를&nbsp;반환한다.(0부터&nbsp;시작)&nbsp;&nbsp;</td>
</tr>
<tr>
<td style="width: 50%; text-align: center;">&nbsp;&nbsp;T&nbsp;valueOf(Class&lt;T&gt;&nbsp;enumType,&nbsp;String&nbsp;name)&nbsp;&nbsp;</td>
<td style="width: 50%; text-align: center;">&nbsp;&nbsp;지정된&nbsp;열거형에서&nbsp;name과&nbsp;일치하는&nbsp;열거형&nbsp;상수를&nbsp;반환한다.&nbsp;</td>
</tr>
</tbody>
</table>
---
### 열거형에 멤버 추가하기

ordinal은 정의된 순서를 반환하지만 상수의 값으로 사용하지 않는 것 추천(내부적인 용도로만 사용)
>상수의 값 불연속적인 경우
enum Direction{East(1),SOUTH(5), WEST(-1), NORTH(10)}
->지정된 값 저장할 수 있는 인스턴스 변수와 생성자 새로 추가해야한다

```
enum Direction{
	EAST(1),SOUTH(5), WEST(-1), NORTH(10); // 끝에 ; 추가해야한다
    
    	private final int value; //정수를 저장할 필드(인스턴스 변수) 를 추가
    	Direction(int value) {this.value = value;} //  생성자를 추가
    
    	public int getValue(){return value;}
    
}
```

> 열거형의 인스턴스 변수는 반드시 final은 아니지만 vlaue는 상수의 값 저장하기 위해 final,
외부에서 값 얻을 수 있는 getValue();

```
Direction d = new Direction(1);  // 에러. 열거형의 생성자는 외부에서 호출 불가
    
```

```
enum Direction {
    ...
    Direction(int value) { // private Direction(int value)와 동일
    ...
}
```

필요하다면 하나의 열거형 상수에 여러 값 -> 인스턴스 변수와 생성자 등을 새로 추가
```
enum Direction{
    EAST(1,">"), SOUTH("2,"V") ,WEST(3,"<"),NORTH(4,"^");
    
    private final int value;
    private final String symbol;
    Direction(int value , String symbol){ // 접근 제어자 private 생략
    	this.value = value;
        this.symbol = symbol;
    }
    
    public int getValue(){return value;}
    public String getSymbol(){return symbol;}
    
	
}
```
---
## 🤑추가공부 열거형에 추상 메서드 추가하기

>열거형 Transportation 은 운송 수단의 종류 별로 상수를 정의하고 
각 운송 수단에는 기본요금(BASIC_FARE) 책정하려는 경우

```
enum Transportation {
    BUS(100), TRAIN(150), SHIP(100) , AIRPLANE(300);
    private final int BASIC_FARE;
    setter,getter
}
```

> 이것으로는 부족  , **거리에 따라 요금을 계산하는 방식이 다를 것**이다
->열거형 추상메서드 fare(int distance) 선언하면 각 열거형 상수가 이 추상 메서드를 반드시 구현

```
enum Transportation {
    BUS(100){
    int fare(int distance){return distance*BASIC_FARE;}
    },
    TRAIN(150){
    int fare(int distance){return distance*BASIC_FARE*2;}
    }, 
    SHIP(100){
    int fare(int distance){return distance*BASIC_FARE*3;}
    } ,
    AIRPLANE(300){
    int fare(int distance){return distance*BASIC_FARE*10;}
    };
    abstract int fare(int distance); // 거리에 따른 요금을 계산하는 추상 메서드
    protected final int BASIC_FARE; // protected로 해야 각 상수에서 접근 가능
    setter,getter
}
```


>출처:https://kils-log-of-develop.tistory.com/430
velog:https://velog.io/@kdong702/ENUMS


