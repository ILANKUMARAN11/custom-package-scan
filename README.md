# Scan the packages of External library from application.yml

### Reference Documentation
* Scan specific packages from External JAR 
  (i.e) scan the packages which given in application.yml

* If no **app.basePackagesToScan** in application.yml, then scan all the packages in External JAR

```yaml
app:
  basePackagesToScan: net.sky.service.inventory, net.sky.service.order
```


```java
@Configuration
public class CustomScanConfig {
    
    @Bean
    @ConditionalOnMissingBean(name = "propertySourcesPlaceholderConfigurer")
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @ComponentScan(basePackages = "${app.basePackagesToScan:net.sky.service}")
    public static class ComponentScanConfig{

    }
    
}
```