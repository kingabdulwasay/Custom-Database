package com.customdatabase.springboot.dtos;

public class RecordDTO{

    public Object data;

    public RecordDTO( Object data) {

        this.data = data;
    }




    public Object getData() {
        return data;
    }
}
