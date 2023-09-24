下载依赖地址https://mvnrepository.com/artifact/top.meethigher/light-statemachine

使用示例

```java
public class Test {

    enum State {
        get_up,
        eat,
        learn,
        sleep
    }

    public static void main(String[] args) {
        StateMachine.getInstance(State.class, State.get_up)
                .addTransition(State.get_up, State.eat, () -> System.out.println("早洗漱"))
                .addTransition(State.eat, State.learn, () -> {
                    System.out.print("准备身份证 ");
                    System.out.print("准备学习资料 ");
                    System.out.println("去图书馆");})
                .addTransition(State.learn, State.sleep, () -> System.out.println("晚洗漱"))
                .addTransition(State.sleep,State.get_up,()-> System.out.println("第二天"))
                .transitionToTargetState(State.eat)
                .transitionToTargetState(State.learn)
                .transitionToTargetState(State.sleep)
                .transitionToTargetState(State.get_up)
                .transitionToTargetState(State.eat)
                .transitionToTargetState(State.sleep);
    }
}
```

