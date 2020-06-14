package pl.gameshop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler
{
    private final Logger log = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException exception) throws IOException, ServletException
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null)
        {
            log.warn("Użykownik : " + auth.getName()
            + " próbował dostać się do adresu strzeżonego :: "
            + request.getRequestURI());
        }

        response.sendRedirect("/403");
    }
}
