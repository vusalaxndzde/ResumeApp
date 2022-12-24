package com.company.resumewebapp.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ControllerUtil {

    public static void errorPage(HttpServletResponse response, String msg) {
        try {
            response.sendRedirect("error?msg=" + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
