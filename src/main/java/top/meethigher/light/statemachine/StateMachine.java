package top.meethigher.light.statemachine;

import java.util.ArrayList;
import java.util.List;

/**
 * 状态机
 *
 * @author chenchuancheng
 * @since 2023/09/21 18:42
 */
public class StateMachine<T extends Enum<T>> {

    /**
     * 当前状态
     */
    private T currentState;

    /**
     * 转换关系
     */
    private final List<Transition<T>> transitions = new ArrayList<>();

    /**
     * 实例化状态机
     *
     * @param enumType     枚举
     * @param initialState 初始状态
     */
    public StateMachine(Class<T> enumType, T initialState) {
        if (!enumType.isEnum()) {
            throw new IllegalArgumentException("The type parameter must be an enum.");
        }
        this.currentState = initialState;
    }

    /**
     * 添加转换关系
     *
     * @param sourceState 起始状态
     * @param targetState 目标状态
     * @param action      动作
     */
    public void addTransition(T sourceState, T targetState, Action action) {
        transitions.add(new Transition<T>(sourceState, targetState, action));
    }

    /**
     * 转换到目标状态，并更新状态机内状态
     *
     * @param targetState 目标状态
     */
    public void transitionToTargetState(T targetState) {
        for (Transition<T> transition : transitions) {
            if (transition.getSourceState() == currentState && transition.getTargetState() == targetState) {
                transition.performAction();
                currentState = targetState;
                return;
            }
        }
        throw new IllegalStateException("Invalid transition from " + currentState + " to " + targetState);
    }

    /**
     * @return 获取目标状态
     */
    public T getCurrentState() {
        return this.currentState;
    }
}