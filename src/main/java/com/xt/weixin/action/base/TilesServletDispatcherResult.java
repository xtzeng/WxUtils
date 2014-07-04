package com.xt.weixin.action.base;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;

import org.apache.struts2.dispatcher.ServletDispatcherResult;

@SuppressWarnings("serial")
public class TilesServletDispatcherResult extends ServletDispatcherResult {

    @Override
    public void execute(ActionInvocation invocation) throws Exception {
        ActionProxy actionProxy = invocation.getProxy();
        String location = String.format("%s/%s.tiles", actionProxy.getNamespace(), actionProxy.getActionName());
        super.doExecute(location, invocation);
    }
}
