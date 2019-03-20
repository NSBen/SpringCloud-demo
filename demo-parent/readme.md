项目结构:

	demo-common	公共依赖
		主要有Cat的AOP埋点
	
	demo-zuul	API网关
		
	下面这些都是demo服务
	demo-service-order	订单
		swaggerApi：http://localhost:8301/swagger-ui.html  
	demo-service-order-api

	demo-service-stock	库存
	demo-service-stock-api
	
	demo-service-account	账户
	demo-service-account-api

组件配置文件:

	RPC调用:SpringCloud+Feign
	
	注册中心:Consul
		application.properties
		
	配置中心:Apollo
		application.properties 配置应用名、端口、Apollo的连接信息
		
	监控系统:Cat
		app.properties	配置应用名和Cat服务端的项目配置信息对应
		client.xml	domain要和Cat服务端的客户端路由配置对应
		
	API网关:Zuul
		demo-zull下面的application.properties
	
	在线Api:swagger2
		地址:http://{ip}:{port}/swagger-ui.html
	
FAQ:
	
	maven镜像
		一些jar包下载不下来,可以尝试换一个maven仓库
		<mirror>  
	      <id>aliyun</id>  
	      <name>aliyun</name>  
	      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>  
	      <mirrorOf>central</mirrorOf>  
	    </mirror>
	
	
	Cat
		cat的客户端jar包可能在maven仓库没有，需要自己在本地编译
		<dependency>
			<groupId>com.dianping.cat</groupId>
			<artifactId>cat-client</artifactId>
			<version>3.0.0</version>
		</dependency> <!--这里报错-->
		git地址：https://github.com/dianping/cat.git
		cd到根目录执行：mvn install -Dmaven.test.skip=true
				
		Cat公有云的仓库地址，编译不行的话配置一下settings.xml再试一下
		<repositories>
		  <repository>
		     <id>central</id>
		     <name>Maven2 Central Repository</name>
		     <layout>default</layout>
		     <url>http://repo1.maven.org/maven2</url>
		  </repository>
		  <repository>
		     <id>unidal.releases</id>
		     <url>http://unidal.org/nexus/content/repositories/releases/</url>
		  </repository>
		</repositories>
	
	
	Consul
		应用需要提供一个心跳检查的接口 /health  如果没有的话注册中心看到服务的状态是不可用的
		配置项：
		#spring.cloud.consul.discovery.healthCheckPath = /health
	
	
	Apollo
		Apollo启动需要用到数据库，保证数据库的服务启动
		
	