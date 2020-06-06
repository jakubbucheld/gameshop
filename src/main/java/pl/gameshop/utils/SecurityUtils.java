package pl.gameshop.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils
{
    public static String getUsername()
    {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
