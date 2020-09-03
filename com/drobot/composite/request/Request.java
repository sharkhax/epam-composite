package com.drobot.composite.request;

public class Request {
    private final String text;
    private final RequestType requestType;

    public Request(String text, RequestType requestType) {
        this.text = text;
        this.requestType = requestType;
    }

    public String getText() {
        return text;
    }

    public RequestType getRequestType() {
        return requestType;
    }
}
