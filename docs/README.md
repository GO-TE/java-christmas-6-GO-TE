# 프리코스 4주차 - 크리스마스

---

### 1. 입력

- [X] 1.식당 방문 날짜를 입력 받는다 (InputView - inputVisitDate)

- 예외 처리
    - [X] 1~31 사이 정수가 아니라면 예외 처리 한다 (DateValidator)

- [X] 주문할 메뉴를 입력 받는다 (InputView - inputOrderMenu)
  1. [X] 주문 금액이 1만원 이하면, 이벤트 처리를 하지 않는다.

 - 예외처리
    - [X] 메뉴판에 없다면 예외 처리 한다 (OrderValidator - validatorEachOrder)
    - [X] 메뉴 갯수가 1 이상 정수가 아니라면 예외 처리 한다 (OrderValidator - validatorEachOrder
    - [X] 음료만 주문한다면 예외 처리 한다 (OrderValidator - checkOnlyDrink)
    - [X] 메뉴 갯수가 20개를 초과하면 예외 처리 한다 (OrderValidator - validateOrderCount)
    - [X] 메뉴 입력 포멧이 아니라면 예외 처리 한다 (OrderValidator - validatorOrderRegex)

<br>

### 2. 방문일 이벤트

- [X] 입력받은 방문 날짜에 대한 이벤트를 처리한다 (Event)
  1. [X] 디데이 할인인가? (Event)
  2. [X] 평일 / 주말인가? (Event)
  3. [X] 일요일 혹은 크리스마스 당일인가? (Event)
- [X] 디데이 할인가격을 계산한다 (Event)
- [X] 메뉴에 따른 이벤트를 처리한다 (setDayDiscountEvent)
  1. [X] 평일이면 디저트 메뉴를 할인한다 
  2. [X] 주말이면 메인 메뉴를 할인한다
  3. [X] 할인 전 금액이 12만원 이상이면 샴페인을 증정한다 (Event - isChampagneEvent)
- [X] 할인 금액에 따라 배지를 부여한다 (Event - setBatch)
  1. [X] 5천원 <= 할인금액 < 1만원 : 별
  2. [X] 1만원 <= 할인금액 < 2만원 : 트리
  3. [X] 2만원 <= 할인금액 : 산타

### 3. 출력
- [X] 안내 멘트를 출력한다
- [X] 주문 메뉴를 출력한다
- [X] 할인 전 금액을 출력한다
- [X] 증정 메뉴를 출력한다
- [X] 혜택 내역을 출력한다
- [X] 총 할인 혜택 금액을 출력한다
- [X] 할인 후 예상 결제 금액을 출력한다
- [X] 12월 이벤트 배지를 출력한다
    

