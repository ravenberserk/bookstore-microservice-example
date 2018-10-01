package com.example.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    private TokenStore tokenStore = new InMemoryTokenStore();

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // @formatter:off
        clients.inMemory()
                .withClient("book-serv")
                .secret(passwordEncoder.encode("${BOOKSERV-PASSWORD}"))
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server")
            .and()
                .withClient("log-serv")
                .secret(passwordEncoder.encode("${LOGSERV-PASSWORD}"))
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server")
            .and()
                .withClient("gateway-serv")
                .secret(passwordEncoder.encode("${GATESERV-PASSWORD}"))
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server")
            .and()
                .withClient("browser")
                .secret(passwordEncoder.encode("${BROWSER-PASSWORD}"))
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("ui")
                .autoApprove(true)
                ;
        // @formatter:on
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager);
    }

}