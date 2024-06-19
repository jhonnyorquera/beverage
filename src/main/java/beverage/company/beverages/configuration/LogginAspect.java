package beverage.company.beverages.configuration;


import beverage.company.beverages.dto.RequestCustomerDto;
import beverage.company.beverages.dto.ResponseCustomerDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LogginAspect {


  @Before("execution(* beverage.company.beverages.service.*.*(..))")
  public void logBeforeAllMethods() {
    System.out.println("this is a log before all methods in pakage ");
  }


  @Before("execution(* beverage.company.beverages.service.impl.*.*(..))")
  public void logBeforeAllMethodImplement() {
    System.out.println("this is a log before all methods in implement ");
  }


  @AfterReturning(pointcut =
      "execution(* beverage.company.beverages.service.impl.CustomerServiceImpl.getCustomerByAlias(String)) "
          + "&& args(alias)", returning = "responseDto")
  public void logAfterGetCustomerByAlias(String alias, ResponseCustomerDto responseDto) {
    System.out.println("Interceptor: Response for alias " + alias + " - " + responseDto.toString());
  }


  @AfterThrowing(pointcut = "execution(* beverage.company.beverages.service.impl.CustomerServiceImpl.getCustomerByAlias(String))", throwing = "ex")
  public void handleException(RuntimeException ex) {
    System.out.println("Exception occurreddddddddddddddddd: " + ex.getMessage());
    // Puedes agregar aquí cualquier lógica adicional de manejo de excepciones
  }


  @AfterThrowing(pointcut = "execution(* beverage.company.beverages.service.impl.CustomerServiceImpl.*(..))", throwing = "ex")
  public void handleExceptionGeneral(RuntimeException ex) {
    System.out.println("Exception GENERAL: " + ex.getMessage());
    // Puedes agregar aquí cualquier lógica adicional de manejo de excepciones
  }


  @Around("execution(* beverage.company.beverages.service.impl.CustomerServiceImpl.getCustomerByAlias(..)) && args(alias)")
  public Object aroundAdvice(ProceedingJoinPoint joinPoint, String alias) throws Throwable {
    // Antes de la ejecución del método objetivo
    System.out.println("Before method execution: " + joinPoint.getSignature().getName());

    Object result;

    if (alias.contains("7")) {
      result = joinPoint.proceed(); // Invocar al método objetivo y obtener el resultado
    } else {
      System.out.println("No procede");
      result = null; // O algún valor por defecto apropiado
    }

    // Después de la ejecución del método objetivo
    System.out.println("After method execution: " + joinPoint.getSignature().getName());

    return result;
  }


  @Around("execution(* beverage.company.beverages.service.impl.CustomerServiceImpl.insertCustomer(..)) && args(requestCustomerDto)")
  public Object aroundAdviceCreate(ProceedingJoinPoint joinPoint, RequestCustomerDto requestCustomerDto) throws Throwable {
    // Antes de la ejecución del método objetivo
    System.out.println("Before method execution: " + joinPoint.getSignature().getName());

    Object result;

    if (requestCustomerDto.getAlias().contains("s")) {
      result = joinPoint.proceed(); // Invocar al método objetivo y obtener el resultado
    } else {
      System.out.println("No procede crear usuario");
      result = null; // O algún valor por defecto apropiado
    }

    // Después de la ejecución del método objetivo
    System.out.println("After method execution: " + joinPoint.getSignature().getName());

    return result;
  }


}
