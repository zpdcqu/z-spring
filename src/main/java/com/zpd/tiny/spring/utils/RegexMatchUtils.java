package com.zpd.tiny.spring.utils;

import java.beans.Expression;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZhengPeidong
 * @date 2019年 11月17日 15:50:50
 */

public class RegexMatchUtils {
    /**
     * 校验表达式
     * @param expression
     * @return
     * @throws Exception
     */
    private static String[] validateExpression(String expression) throws Exception {
        Pattern compile = Pattern.compile("(?<=\\().+?\\)");
        Matcher matcher = compile.matcher(expression);
        if (!matcher.find()){
            throw new Exception("表达式错误");
        }
        String[] split = matcher.group().split(" ");
        if (split.length<=1){
            throw new Exception("表达式错误");

        }
        return split;
    }

    public static String marchModifier(String expression) throws Exception {
        String[] split = validateExpression(expression);
        return split[0];
    }
}





























