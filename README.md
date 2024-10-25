## Auto packages of External JAR


##### 1) Package structure
![Package structure](doc/images/Packages.png)

> **_NOTE:_**
> * If **NO** **app.basePackagesToScan** given in application.yml
    , then **AUTO** scan all the packages in External JAR.
>
> 
> * Scan specific packages of External JAR 
  (i.e) scan the packages given in **application.yml**.


##### 2) Scanning specific package by property
```yaml
app:
  basePackagesToScan: net.sky.service.inventory, net.sky.service.order
```

##### 3) Custom Logic to scan packages
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