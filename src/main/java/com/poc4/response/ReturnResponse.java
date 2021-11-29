package com.poc4.response;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
@Data
public class ReturnResponse {
private boolean success;
private Map<Object,Object> result=new HashMap<Object,Object>();
}
