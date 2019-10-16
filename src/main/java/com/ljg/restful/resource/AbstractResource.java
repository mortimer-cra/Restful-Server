package com.ljg.restful.resource;

import com.ljg.restful.model.ModelManager;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import java.util.Objects;

public abstract class AbstractResource {

    @Context
    private ServletContext servletContext;
    private ModelManager modelManager;


    //先执行的方法
    @PostConstruct
    private void init(){
        modelManager = Objects.requireNonNull((ModelManager)servletContext.getAttribute("com.ljg.restful.model.ModelManager"),"nothing");
    }

    protected ModelManager getModelManager(){return modelManager;}
}
