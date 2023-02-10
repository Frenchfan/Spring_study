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

//        long begin = System.currentTimeMillis();
        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice: " +
                    "было поймано исключение " + e);
            //targetMethodResult = "Неизвестное название книги";
            //нам приходится передать значение в targetMethodResult,
            //иначе оно так и будет равно null
            throw e;//после проброса исключения дальнейшие строки кода не сработают
        }

        //Меняем результат работы target метода
        //targetMethodResult = "Преступление и наказание";
//
//        long end = System.currentTimeMillis();
//
//        System.out.println("aroundReturnBookLoggingAdvice(): " +
//                "метод returnBook выполнил работу за " + (end - begin) + " миллисекунд");

        System.out.println("aroundReturnBookLoggingAdvice(): " +
                "в библиотеку успешно вернули книгу");

        return targetMethodResult;
    }
}
