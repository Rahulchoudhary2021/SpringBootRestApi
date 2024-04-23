package com.example.demo;
import static net.bytebuddy.matcher.ElementMatchers.nameStartsWith;
import static net.bytebuddy.matcher.ElementMatchers.named;

import java.lang.instrument.Instrumentation;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;

public class MyAgent {
    public static void premain(String arguments, Instrumentation inst) {
        new AgentBuilder.Default()
            .type(nameStartsWith("com.example.demo"))
            .transform((builder, typeDescription, classLoader, javaModule) ->
                builder.method(named("ResponseEntity"))
                       .intercept(Advice.to(MyAdvice.class))
            ).installOn(inst);
    }

    public static class MyAdvice {
        @Advice.OnMethodEnter
        static void enterMethod(@Advice.Origin String method) throws Exception {
            System.out.println("Entering method: " + method);
        }

        @Advice.OnMethodExit(onThrowable = Throwable.class)
        static void exitMethod(@Advice.Origin String method, @Advice.Thrown Throwable throwable) {
            System.out.println("Exiting method: " + method);
            if (throwable != null) {
                System.out.println("Exception: " + throwable.getMessage());
            }
        }
    }
}
