package fr.lernejo.todo;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements Filter {

    private final String uuid = UUID.randomUUID().toString();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {

        if (servletResponse instanceof HttpServletResponse httpServletResponse) {
            httpServletResponse.addHeader("Instance-Id", uuid);
        }

        // Before the rest (filters, servlet)
        filterChain.doFilter(servletRequest, servletResponse);
        // After the rest (filters, servlet)
    }
}
