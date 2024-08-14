package com.yedam.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	@Bean // 비밀번호 암호화
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// 인증 및 인가
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // http => 시큐리티가 적용될 url
		http.authorizeHttpRequests((authrize) -> authrize
					.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
					.requestMatchers("/", "/all").permitAll()
					.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
					.requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
					.anyRequest().authenticated()
				)
				.formLogin(formlogin -> formlogin.defaultSuccessUrl("/all"))
				.logout(logout -> logout.logoutSuccessUrl("/all").invalidateHttpSession(true));
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}
	
	// 메모리방식
//	@Bean
//	InMemoryUserDetailsManager inMemoryUserDetailService() {
//		UserDetails user = User.builder().username("user1").password(passwordEncoder().encode("1234")).roles("USER").build();
//		UserDetails admin = User.builder().username("admin1").password(passwordEncoder().encode("1234")).authorities("ROLE_ADMIN", "ROLE_USER").build();
//		return new InMemoryUserDetailsManager(user, admin);
//	}
}
