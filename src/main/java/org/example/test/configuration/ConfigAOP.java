package org.example.test.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ConfigAOP {

    @AfterThrowing("execution(* org.example.test.service.implementation.RencontreImpl.affecterArbitreARencontre(..))")
    void logException(JoinPoint joinPoint){
        log.info("Il faut affecter un arbitre de meme que la rencontre");
        System.out.println("Il faut affecter un arbitre de meme que la rencontre");
    }

}
