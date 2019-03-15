组件:
	RPC:SpringCloud+Feign
	注册中心:Consul
	配置中心:Apollo
		application.properties 配置应用名、端口、Apollo的连接信息
	监控系统:Cat
		app.properties	配置应用名和Cat服务端的项目配置信息对应
		client.xml	domain要和Cat服务端的客户端路由配置对应
	API网关:Zuul