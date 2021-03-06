package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 待支付
 */
@Data
@Component
public class ToBePaidWorkOrderAction extends WorkOrderActionAdapter implements Serializable {

    private final String name = WorkOrderState.toBePaid.name();

    @Override
    public WorkOrderState getType() {
        return WorkOrderState.toBePaid;
    }

    @Override
    public void paymentCompleted(WorkOrderStateMachine stateMachine) {
        super.paymentCompleted(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.toBeConfirmedWorkOrderAction);
    }
}
