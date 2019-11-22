package com.zpd.tiny.spring.context.resource;

/**
 * Resourcce工厂
 */
public interface ResourceFactory {

    Resource getResource(String locations) throws Exception;
}


