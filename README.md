## Scan the packages of External JAR from application.yml

### Reference Documentation
* Scan specific packages from External JAR 
  (i.e) scan the packages given in **application.yml**.

* If **NO** **app.basePackagesToScan** in application.yml, then scan all the packages in External JAR.

![](doc/images/Packages.png)

##### Scanning specific package by property
```yaml
app:
  basePackagesToScan: net.sky.service.inventory, net.sky.service.order
```

##### Custom Logic to scan packages
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