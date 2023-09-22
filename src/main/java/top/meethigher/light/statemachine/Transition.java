package top.meethigher.light.statemachine;

/**
 * 转换状态时的动作
 *
 * @author chenchuancheng
 * @since 2023/09/22 20:19
 */
public class Transition<T extends Enum<T>> {

    /**
     * 起始状态
     */
    private final T sourceState;

    /**
     * 目标状态
     */
    private final T targetState;

    /**
     * 动作: 由 sourceState 到 targetState 过程中，需要执行的业务逻辑
     */
    private final Action action;

    /**
     * 实例化转换关系
     *
     * @param sourceState 起始状态
     * @param targetState 目标状态
     * @param action      动作
     */
    public Transition(T sourceState, T targetState, Action action) {
        this.sourceState = sourceState;
        this.targetState = targetState;
        this.action = action;
    }


    /**
     * @return 起始状态
     */
    public T getSourceState() {
        return sourceState;
    }

    /**
     * @return 目标状态
     */
    public T getTargetState() {
        return targetState;
    }


    /**
     * 执行动作
     */
    public void performAction() {
        this.action.perform();
    }
}