package top.meethigher.light.statemachine;

/**
 * 转换状态时的动作
 *
 * @author chenchuancheng
 * @since 2023/09/21 19:01
 */
public interface Action {


    /**
     * 转换状态时，需要执行的业务逻辑
     */
    void perform();
}
