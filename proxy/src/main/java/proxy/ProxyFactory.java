package proxy;

import javassist.*;
import java.lang.reflect.Method;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName ProxyFactory.java
 * @Description TODO
 * @createTime 2022年07月03日 21:53:00
 */
public class ProxyFactory {
    /**========================1===========================*/
    //javassist工具类,javassist和cglib的底层都是asm，原理：javassist -->asm -->编辑字节码.class
    public static TestService createProxy() throws Exception {
        //1.创建一个类
        ClassPool classPool = new ClassPool();
        //classloader
        classPool.appendSystemPath();
        final CtClass class1 = classPool.makeClass("TestServiceImpl");
        class1.addInterface(classPool.get(TestService.class.getName()));
        //2.创建一个方法
        final CtMethod sayHello = CtNewMethod.make(CtClass.voidType,
                "sayHello", new CtClass[]{classPool.get(String.class.getName())}
                , new CtClass[0], "{System.out.println(\"hello:\" + $1);}", class1);
        class1.addMethod(sayHello);
        //3.实例化这个对象
        final Class aClass = classPool.toClass(class1);
        //强制转换
        return (TestService) aClass.newInstance();
    }

    public interface TestService {
        void sayHello(String name);
    }



    /**========================2===========================*/
    public static <T> T createProxy2(Class<T> claInterface, String src) throws Exception {
        //1.创建一个类
        ClassPool classPool = new ClassPool();
        //classloader
        classPool.appendSystemPath();
        final CtClass class1 = classPool.makeClass("TestServiceImpl");
        class1.addInterface(classPool.get(claInterface.getName()));
        //2.创建一个方法
        final CtMethod sayHello = CtNewMethod.make(CtClass.voidType,
                "sayHello", new CtClass[]{classPool.get(String.class.getName())}
                , new CtClass[0], src, class1);
        class1.addMethod(sayHello);
        //3.实例化这个对象
        final Class aClass = classPool.toClass(class1);
        //强制转换
        return (T) aClass.newInstance();
    }

    public interface TestService2 {
        void sayHello(String name);
        void sayHello2(String name);
    }


    /**========================3===========================*/
    public interface InvocationHandler{
        Object invoke(String methodName, Object args[]);
    }
    public class InvocationHandlerImpl implements InvocationHandler{
        @Override
        public Object invoke(String methodName, Object args[]){
            System.out.println("hello");
            return null;
        }
    }
    static int count = 0;
    public static <T> T createProxy3(Class<T> cla, InvocationHandler handler) throws Exception {
        //1.创建一个类
        //1.创建一个类
        ClassPool classPool = new ClassPool();
        //classloader
        classPool.appendSystemPath();
        final CtClass impl = classPool.makeClass("$proxy" + count++);

        //2.添加属性 保存handler属性
        final CtField field = CtField.make("public proxy.ProxyFactory.InvocationHandler handler = null;", impl);
        for (Method method : cla.getMethods()) {
            CtClass returnType = classPool.get(method.getReturnType().getName());
            String name = method.getName();
        }

        //3.创建这个接口下的所有方法


        //4.实例化这个对象
        //强制转换
        return null;
    }


    //1.支持所有接口的代理
    //2.按常规的方式传递实现
    public static void main(String[] args) throws Exception {
        final TestService2 proxy = createProxy2(TestService2.class,"{System.out.println(\"hello:\" + $1);}");
        proxy.sayHello("wsl");
        proxy.sayHello2("wsl");
    }
}
