package com.sportoras.web.utilit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JspPathUtil {

    private static final String FORMAT = "/WEB-INF/jsp/%s.jsp";
    public static String get(String jspName) {
        return String.format(FORMAT, jspName);
    }
}