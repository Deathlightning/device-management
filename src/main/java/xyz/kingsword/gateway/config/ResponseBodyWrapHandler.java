//package xyz.kingsword.gateway.config;
//
//import org.springframework.core.MethodParameter;
//import org.springframework.web.context.request.NativeWebRequest;
//import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
//import org.springframework.web.method.support.ModelAndViewContainer;
//
//import javax.servlet.http.HttpServletResponse;
//import java.lang.annotation.*;
//
///**
// * @author: wzh date: 2019-04-15 08:39
// * @version: 1.0
// **/
//public class ResponseBodyWrapHandler implements HandlerMethodReturnValueHandler {
//
//    private final HandlerMethodReturnValueHandler delegate;
//
//    public ResponseBodyWrapHandler(HandlerMethodReturnValueHandler delegate) {
//        this.delegate = delegate;
//    }
//
//    @Override
//    public boolean supportsReturnType(MethodParameter returnType) {
//        return delegate.supportsReturnType(returnType);
//    }
//
//    @Override
//    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
//        System.out.println(returnValue);
//        System.out.println(returnType);
//        System.out.println(mavContainer);
//        System.out.println(webRequest);
//        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
//        response.setContentType("application/json;charset=UTF-8");
//        delegate.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
//    }
//}