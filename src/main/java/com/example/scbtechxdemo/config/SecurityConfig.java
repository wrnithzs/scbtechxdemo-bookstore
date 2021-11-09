package com.example.scbtechxdemo.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.scbtechxdemo.security.CustomUserDetailsService;
import com.example.scbtechxdemo.security.JWTAuthenticationFilter;
import com.example.scbtechxdemo.security.JWTAuthorizationFilter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomUserDetailsService customUserDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public SecurityConfig(CustomUserDetailsService customUserDetailsService,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.customUserDetailsService = customUserDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/*").permitAll()
				.antMatchers("/books").permitAll()
				.antMatchers(HttpMethod.POST, "/users").permitAll()
				.antMatchers(HttpMethod.DELETE, "/users/*").hasAnyAuthority("user")
				.antMatchers(HttpMethod.GET, "/users").hasAnyAuthority("user")
				.antMatchers(HttpMethod.POST, "/users/orders").hasAnyAuthority("user").anyRequest().authenticated()
				.and().authorizeRequests()
				.and().exceptionHandling()
				.authenticationEntryPoint((req, res, error) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
				.addFilter(authenticationFilter()).sessionManagement().and()
				.addFilter(new JWTAuthorizationFilter(authenticationManager())).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	UsernamePasswordAuthenticationFilter authenticationFilter() throws Exception {
		final UsernamePasswordAuthenticationFilter filter = new JWTAuthenticationFilter(authenticationManager());
		filter.setAuthenticationManager(authenticationManager());
		return filter;
	}
}