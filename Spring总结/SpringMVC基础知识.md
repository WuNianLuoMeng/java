# SpringMVC基础知识



### *前端控制器的配置

+ 理解：就是用来配置存在xml中的映射器,适配器,视图解析器.

~~~ xml
 <!-- springmvc前端控制器 -->
  <servlet>
  	<servlet-name>springmvc</servlet-name>
  	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  	<!-- contextConfigLocation配置springmvc加载的配置文件（配置处理器映射器、适配器等等）
  	如果不配置contextConfigLocation，默认加载的是/WEB-INF/servlet名称-serlvet.xml（springmvc-servlet.xml）
  	 -->
  	<init-param>
  		<param-name>contextConfigLocation</param-name>
        <!-- 可以加载多个xml文件-->
  		<param-value>classpath:springmvc2.xml,classpath:springmvc1.xml</param-value>
  	</init-param>
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>springmvc</servlet-name>
  	<!-- 
  	第一种：*.action，访问以.action结尾 由DispatcherServlet进行解析
  	第二种：/，所以访问的地址都由DispatcherServlet进行解析，对于静态文件的解析需要配置不让DispatcherServlet进行解析
  	使用此种方式可以实现 RESTful风格的url
  	第三种：/*，这样配置不对，使用这种配置，最终要转发到一个jsp页面时，
  	仍然会由DispatcherServlet解析jsp地址，不能根据jsp页面找到handler，会报错。
  	
  	 -->
  	<url-pattern>*.action</url-pattern>
  </servlet-mapping>
~~~

+ springmvc.xml中的内容(采用非注解的方式来配置适配器,映射器,视图解析器,控制器)

  ~~~ xml
  <!-- 配置handler -->
  	<!-- 通过test.action和test1.action都是可以访问control.controler1的-->
  	<bean id="controler1" name="/test.action" class="control.controler1"></bean>
  	<bean id="controler2" class="control.controler2"></bean>
  	<!-- 第一种配置映射器的方法 -->
  <!-- 	<bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/> -->
  	<!-- 第二种配置映射器的方法 -->
  	<bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
  		<property name="mappings">
  			<props>
  				<prop key="/test1.action">
  					controler1
  				</prop>
  				<prop key="/test2.action">
  					controler2
  				</prop>
  			</props>
  		</property>
  	</bean>
  	<!--配置适配器 -->
  	<bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>
  <!-- 第二种适配器-->
  <!-- 	<bean class="org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter"></bean> -->
  	<!--配置视图解析器  -->
  	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"/>
  ~~~

+ Springmvc2.xml(采用注解的方式来配置适配器,映射器,视图解析器,控制器,实现较为简单)

  ~~~ xml
  <!-- 组件扫描 -->
  	<context:component-scan base-package="control1"></context:component-scan>
  	<!-- 注解的方式来实现配置器，映射器的配置 -->
  	<mvc:annotation-driven></mvc:annotation-driven>
  	<!--配置视图解析器  -->
  	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"/>
  ~~~

  用该种方式来进行配置的时候，需要使用@Controller来标识一个class为控制器，并且使用@RequestMapping来完成url与控制器中方法的映射。