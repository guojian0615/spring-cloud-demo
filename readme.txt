# ribbon和feign都用于负载均衡，在调用端配置

ribbon提供rest api方式调用
feign提供接口方式调用，其实也是对restfulapi的包装，提供类似接口的方式调用


熔断机制，通过hystrix在服务端配置
服务降级，通过feign+hystrix在调用端配置
