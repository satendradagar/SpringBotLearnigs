package com.satendra.springLearn.SpringBot.Learnigs.HelloWorld;


public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message){
        this.message = message;
    }


    public  void  setMessage(String message){
        this.message = message;
     }

    public String getMessage() {
        return  message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean [msh=%s] ",message);
    }
}
