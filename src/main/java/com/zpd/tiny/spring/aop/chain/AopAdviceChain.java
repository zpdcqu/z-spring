package com.zpd.tiny.spring.aop.chain;

import com.zpd.tiny.spring.aop.advice.Advice;
import com.zpd.tiny.spring.aop.advice.AfterAdvice;
import com.zpd.tiny.spring.aop.advice.AroundAdvice;
import com.zpd.tiny.spring.aop.advice.BeforeAdvice;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 责任链式执行advice的增强
 *
 * @author ZhengPeidong
 * @date 2019年 11月14日 23:20:50
 */

public class AopAdviceChain {

    // 下一个方法
    private Method nextMethod;

    // 方法
    private Method method;

    // 目标
    private Object target;

    // 参数
    private Object[] args;

    // 代理
    private Object proxy;

    // 通知
    private List<Advice> advices;

    //通知索引，记录执行到多少个advice
    private int index = 0;


    /**
     * 构造函数
     * @param method 方法
     * @param target 目标
     * @param args   入参
     * @param proxy  代理
     * @param advices通知
     */
    public AopAdviceChain(Method method, Object target, Object[] args, Object proxy, List<Advice> advices) {

        try {
            nextMethod = AopAdviceChain.class.getMethod("invoke");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        this.method = method;
        this.target = target;
        this.args = args;
        this.proxy = proxy;
        this.advices = advices;
    }

    /**
     *  执行
     * @return
     */
    public Object invoke(){
        if (index<this.advices.size()){
            Advice advice  = this.advices.get(index++);
            if (advice instanceof BeforeAdvice){
                //前置增强
                (  (BeforeAdvice) advice).before(method,args,target);
            }else if (advice instanceof AroundAdvice){
                // 环绕
                return ((AroundAdvice) advice).around(nextMethod,args,target);
            }else if (advice instanceof AfterAdvice){
                // 后置
                Object res = this.invoke();
                ((AfterAdvice) advice).after(method,args,target,res);

                return res;
            }
            // 递归
            return this.invoke();
        }else {
            return method.invoke(target,args);
        }

    }
}
