package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint
                                                          proceedingJoinPoint)
            throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice(): " +
                "в библиотеку пытаются вернуть книгу");

        long begin = System.currentTimeMillis();

        Object targetMethodResult = proceedingJoinPoint.proceed();

        //Меняем результат работы target метода
        targetMethodResult = "Преступление и наказание";

        long end = System.currentTimeMillis();

        System.out.println("aroundReturnBookLoggingAdvice(): " +
                "метод returnBook выполнил работу за " + (end - begin) + " миллисекунд");

        System.out.println("aroundReturnBookLoggingAdvice(): " +
                "в библиотеку успешно вернули книгу");

        return targetMethodResult;
    }
}
