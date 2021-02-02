package pt.sample.service.functions;

import org.flowable.common.engine.api.FlowableException;
import org.flowable.common.engine.api.delegate.FlowableFunctionDelegate;

import java.lang.reflect.Method;
import java.util.Date;

public class NextBusinessDay implements FlowableFunctionDelegate {

    @Override
    public String prefix() {
        return "date";
    }

    @Override
    public String localName() {
        return "nextBusinessDay";
    }

    @Override
    public Method functionMethod() {
        try {
            return DateUtils.class.getDeclaredMethod("nextBusinessDate", Date.class);
        } catch (NoSuchMethodException e) {
            throw new FlowableException("Error getting method", e);
        }
    }
}
