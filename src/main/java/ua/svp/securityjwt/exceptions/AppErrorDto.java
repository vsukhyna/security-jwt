package ua.svp.securityjwt.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class AppErrorDto {

    private String message;
    private Date timestamp;

    public AppErrorDto(String message) {
        this.message = message;
        this.timestamp = new Date();
    }
}
