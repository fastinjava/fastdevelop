# 1
```
@Configuration
@ComponentScan(value = {"com.fastdevelop.main1"})
@Service
```
默认id为类名首字母小写

# 2
```
@Configuration
@Import(value = {UserDao.class})
```
默认id为类名全类名

# 3
```
@Configuration
@Import(value = {MyImportSelector.class})

public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.fastdevelop.main1.service.UserService"};
    }
}
```
默认id为类名全类名