package CTTNHH_BaooLam_Group.Practice_English_App_BE.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import CTTNHH_BaooLam_Group.Practice_English_App_BE.Service.MyUserDetailService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Autowired
    private MyUserDetailService userDetailService;

    @SuppressWarnings({ "removal", "deprecation" })
    @Bean
    public SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception{
        
        http
            .csrf(customizer -> customizer.disable())
            .authorizeRequests(request -> request.anyRequest().authenticated())
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults())
            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
            
        return http.build();
    }


    @SuppressWarnings("deprecation")
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());// NoopPasswordEncoder.getInstance() for using in testing
            return provider;

    } 

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user1 = User.withDefaultPasswordEncoder()
                                .username("baoolam")
                                .password("123")
                                .roles("ADMIN")
                                .build();


        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("baolam")
                .password("123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1,user2); 
    }

    // @Bean
    // PasswordEncoder passwordEncode(){
    //     return new BCryptPasswordEncoder();
    // }
}
