package com.losgif.senbeiapi.filters;

import com.losgif.senbeiapi.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.losgif.senbeiapi.utils.JwtUtil.ROLE;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final PathMatcher pathmatcher = new AntPathMatcher();
    private final String[] protectUrlPattern = {"/manage/**", "/member/**", "/auth/**"}; //哪  些请求需要进行安全校验

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (isProtectedUrl(httpServletRequest)) {
                Map<String, Object> claims = JwtUtil.validateTokenAndGetClaims(httpServletRequest);
                String role = String.valueOf(claims.get(ROLE));
                String userid = String.valueOf(claims.get("userid"));

                //最关键的部分就是这里, 我们直接注入了
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                        userid, null, List.of(() -> role)
                ));

            }
        } catch (Exception e) {
            e.printStackTrace();
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);


    }

    //是否是保护连接
    private boolean isProtectedUrl(HttpServletRequest request) {

        boolean flag = false;

        for (String s : protectUrlPattern) {
            if (pathmatcher.match(s, request.getServletPath())) {
                return true;
            }
        }

        return false;
    }
}
