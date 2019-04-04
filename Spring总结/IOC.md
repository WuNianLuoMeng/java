# IOC

### 1，Bean的装配

+ 自动化装配bean

  + 声明一个@Component->组件自动扫描(@ComponentScan/基于XML：<context:compontent-scan base-pase-package="包名">) 

+ 通过java代码装配bean

  + 通过@Bean注解来声明一个bean->通过一个@Configuration创建一个配置类->通过@

+ 通过XML来装配bean

  + <bean id=""class="类路径">
  + 如果要注入bean的话，通过<constructor-arg ref="引入bean_id"/>标签

+ DI

  + 如果要注入bean的话，通过<constructor-arg ref="引入bean_id"/>标签

  + ~~~ java
    public class Test{
        String name;
        String password;
        public Test(String name,String password){
            this.name=name;
            this.password=password;
        }
    }
    <construcor-arg value="Tom"/>
    <construcor-arg value="123"/>
    ~~~

  + 