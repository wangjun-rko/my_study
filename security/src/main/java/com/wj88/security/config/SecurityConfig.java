package com.wj88.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SecurityConfig
 *
 * @author huayu
 * @version 1.0
 * @description Security配置类
 * @date 2019/7/24 10:22
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("wj99").roles("admin")
            .password(passwordEncoder().encode("123")).and().withUser("wj77")
            .roles("user").password(passwordEncoder().encode("123"));
    }
    @Bean(name="passwordEncoder")
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // /anon1,/anon2两个路径访问不受权限保护，可以任意访问
        // 其它路径都要进行身份认证，认证的方式formlogin表单登录。然后接着又指定表单登录的时候用到的登录页面地址
        //是"/login"。defaultSuccessUrl指明了登录成功后跳转的页面("/user")，当然可以不用指定defaultSuccessUrl，这种情况下spring security会默认跳转到"/"页面
        http.authorizeRequests().antMatchers("/anon1", "/anon2").permitAll().anyRequest().authenticated().and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/user").permitAll().and().logout().permitAll();
    }
}
